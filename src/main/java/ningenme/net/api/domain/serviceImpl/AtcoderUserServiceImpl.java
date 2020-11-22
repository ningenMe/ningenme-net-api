package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.AtcoderUser;
import ningenme.net.api.domain.repository.AtcoderUserClientRepository;
import ningenme.net.api.domain.repository.AtcoderUserMysqlRepository;
import ningenme.net.api.domain.repository.BatchMysqlRepository;
import ningenme.net.api.domain.service.AtcoderUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AtcoderUserServiceImpl implements AtcoderUserService {
  private final AtcoderUserClientRepository atcoderUserClientRepository;
  private final AtcoderUserMysqlRepository atcoderUserMysqlRepository;
  private final BatchMysqlRepository batchMysqlRepository;
  private final static String ALL_ATCODER_USER_LIST_PAGE = "all_atcoder_user_list_page";
  private final static String CURRENT_ATCODER_USER_LIST_PAGE = "current_atcoder_user_list_page";
  private final static Integer ONE_PROCESS_USER_LIST_SIZE = 100;

  //TODO ロジック肥大化しすぎ
  @Override
  public void putId() {
    //最大ページ数をatcoder側から取得
    Integer allPageNum = atcoderUserClientRepository.getAllPageNum();
    batchMysqlRepository.put(ALL_ATCODER_USER_LIST_PAGE, allPageNum.toString());
    //現在ページ数をdbから取得
    Integer currentPageNum = Integer.valueOf(batchMysqlRepository.get(CURRENT_ATCODER_USER_LIST_PAGE));
    //現在ページ数のユーザリストを取得
    List<AtcoderUser> atcoderUserList = atcoderUserClientRepository.get(currentPageNum);
    //ユーザIDを更新
    for (AtcoderUser atcoderUser: atcoderUserList) {
      atcoderUserMysqlRepository.putId(atcoderUser);
    }
    //現在ページ数を加算
    if(currentPageNum.equals(allPageNum)) {
      currentPageNum = 0;
    }
    else {
      currentPageNum += 1;
    }
    //現在ページ数を更新
    batchMysqlRepository.put(CURRENT_ATCODER_USER_LIST_PAGE,String.valueOf(currentPageNum));
  }

  @Override
  public void put() {
    AtcoderUser atcoderUser       = atcoderUserMysqlRepository.getOldestOne();
  }
}
