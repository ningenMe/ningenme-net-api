package ningenme.net.api.compro.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.compro.domain.entity.AtcoderUser;
import ningenme.net.api.compro.domain.entity.AtcoderUserHistory;
import ningenme.net.api.compro.domain.repository.AtcoderUserAtcoderRepository;
import ningenme.net.api.compro.domain.repository.AtcoderUserHistoryAtcoderRepository;
import ningenme.net.api.compro.domain.repository.AtcoderUserHistoryMysqlRepository;
import ningenme.net.api.compro.domain.repository.AtcoderUserMysqlRepository;
import ningenme.net.api.compro.domain.service.AtcoderUserService;
import ningenme.net.api.compro.domain.value.*;
import ningenme.net.api.util.domain.repository.BatchMysqlRepository;
import ningenme.net.api.util.domain.value.LogCode;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class AtcoderUserServiceImpl implements AtcoderUserService {
  private final BatchMysqlRepository batchMysqlRepository;
  private final AtcoderUserAtcoderRepository atcoderUserAtcoderRepository;
  private final AtcoderUserMysqlRepository atcoderUserMysqlRepository;
  private final AtcoderUserHistoryAtcoderRepository atcoderUserHistoryAtcoderRepository;
  private final AtcoderUserHistoryMysqlRepository atcoderUserHistoryMysqlRepository;

  private final static String ALL_ATCODER_USER_LIST_PAGE = "all_atcoder_user_list_page";
  private final static String CURRENT_ATCODER_USER_LIST_PAGE = "current_atcoder_user_list_page";
  private final static Integer BINGO_MAX_RUNK = 100;
  private final static ContestId UNKNOWN_CONTEST_ID = ContestId.of("UNKNOWN");

  @Override
  public void putId() {
    //最大ページ数をatcoder側から取得
    Integer allPageNum = atcoderUserAtcoderRepository.getAllPageNum();
    //最大ページ数を更新
    batchMysqlRepository.put(ALL_ATCODER_USER_LIST_PAGE, allPageNum.toString());
    //現在ページ数をdbから取得
    Integer currentPageNum = Integer.valueOf(batchMysqlRepository.get(CURRENT_ATCODER_USER_LIST_PAGE));
    //現在ページ数のユーザリストを取得
    List<AtcoderUser> atcoderUserList = atcoderUserAtcoderRepository.get(currentPageNum);
    //ユーザIDを更新
    for (AtcoderUser atcoderUser: atcoderUserList) {atcoderUserMysqlRepository.putId(atcoderUser);}
    //現在ページ数を加算
    if(currentPageNum.equals(allPageNum)) { currentPageNum = 1; }
    else { currentPageNum += 1; }
    //現在ページ数を更新
    batchMysqlRepository.put(CURRENT_ATCODER_USER_LIST_PAGE,String.valueOf(currentPageNum));
  }

  @Override
  public void put() {
    //更新対象である一番古いatcoderIdを取得
    AtcoderUser atcoderUser = atcoderUserMysqlRepository.getOldestOne();
    log.info("code={},message={}", LogCode.API_INFO_207.getCode(),LogCode.API_INFO_207.getMessage()+atcoderUser.getAtcoderId().getValue());
    //atcoderIdをもとに、最新データを本家から取得
    List<AtcoderUserHistory> atcoderUserHistoryList = atcoderUserHistoryAtcoderRepository.get(atcoderUser.getAtcoderId());
    //リストが空の場合削除して終了 多分このパターンはない
    //TODO 「最終参加が1年前」とかの基準でユーザのデータを削除して良さそう。そうすると大体のパターンで退会ユーザを弾ける
    if(atcoderUserHistoryList.isEmpty()) {
      atcoderUserMysqlRepository.delete(atcoderUser);
      return;
    }
    //ヒストリーデータ更新
    for (AtcoderUserHistory atcoderUserHistory:atcoderUserHistoryList) {
      atcoderUserHistoryMysqlRepository.put(atcoderUserHistory);
    }
    //ユーザデータを最新まで繰越し
    atcoderUserMysqlRepository.put(atcoderUser);
    //TODO ここでコンテストのテーブル更新もやっといたほうが良さそう？(コンテストデータ自体は別のクローラー立てても良さそう)
  }

  @Override
  public AtcoderUser getOne(AtcoderId atcoderId) {
    return atcoderUserMysqlRepository.getOne(atcoderId);
  }

  @Override
  public List<AtcoderUserHistory> getBingo(AtcoderId atcoderId, BingoType bingoType) {
    //history一覧取得
    List<AtcoderUserHistory> atcoderUserHistories = atcoderUserHistoryMysqlRepository.get(atcoderId);

    //BINGO_MAX_RUNK以下のものをfiltering
    Map<Integer,AtcoderUserHistory> map = new HashMap<>();
    for (AtcoderUserHistory atcoderUserHistory: atcoderUserHistories) {
      if(Optional.ofNullable(atcoderUserHistory.getPlace()).map(place -> place.getValue() > BINGO_MAX_RUNK).orElse(true)) {
        continue;
      }
      if(!bingoType.isOwnType(atcoderUserHistory.getContestId())) {
        continue;
      }
      map.put(atcoderUserHistory.getPlace().getValue(),atcoderUserHistory);
    }

    //レスポンスを作成
    List<AtcoderUserHistory> bingos = new ArrayList<>();
    for(Integer place = 1; place <= BINGO_MAX_RUNK; place += 1) {
      if (map.containsKey(place)) {
        bingos.add(map.get(place));
      }
      else {
        bingos.add(AtcoderUserHistory
                .builder()
                .atcoderId(atcoderId)
                .contestId(UNKNOWN_CONTEST_ID)
                .place(Place.of(place))
                .performance(Performance.of(0))
                .build()
        );
      }
    }

    return bingos;
  }
}
