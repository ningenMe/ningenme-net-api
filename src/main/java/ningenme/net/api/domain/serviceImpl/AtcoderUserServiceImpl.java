package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.AtcoderUser;
import ningenme.net.api.domain.entity.AtcoderUserHistory;
import ningenme.net.api.domain.entity.ComproContest;
import ningenme.net.api.domain.repository.*;
import ningenme.net.api.domain.service.AtcoderUserService;
import ningenme.net.api.domain.value.AtcoderId;
import ningenme.net.api.domain.value.ComproSite;
import ningenme.net.api.domain.value.LogCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AtcoderUserServiceImpl implements AtcoderUserService {
  private final BatchMysqlRepository batchMysqlRepository;
  private final AtcoderUserClientRepository atcoderUserClientRepository;
  private final AtcoderUserMysqlRepository atcoderUserMysqlRepository;
  private final AtcoderUserHistoryClientRepository atcoderUserHistoryClientRepository;
  private final AtcoderUserHistoryMysqlRepository atcoderUserHistoryMysqlRepository;

  private final static String ALL_ATCODER_USER_LIST_PAGE = "all_atcoder_user_list_page";
  private final static String CURRENT_ATCODER_USER_LIST_PAGE = "current_atcoder_user_list_page";

  @Override
  public void putId() {
    //最大ページ数をatcoder側から取得
    Integer allPageNum = atcoderUserClientRepository.getAllPageNum();
    //最大ページ数を更新
    batchMysqlRepository.put(ALL_ATCODER_USER_LIST_PAGE, allPageNum.toString());
    //現在ページ数をdbから取得
    Integer currentPageNum = Integer.valueOf(batchMysqlRepository.get(CURRENT_ATCODER_USER_LIST_PAGE));
    //現在ページ数のユーザリストを取得
    List<AtcoderUser> atcoderUserList = atcoderUserClientRepository.get(currentPageNum);
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
    List<AtcoderUserHistory> atcoderUserHistoryList = atcoderUserHistoryClientRepository.get(atcoderUser.getAtcoderId());
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
}
