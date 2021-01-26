package ningenme.net.api.compro.infrastructure.atcoder;

import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.compro.domain.entity.AtcoderUser;
import ningenme.net.api.compro.domain.exception.ScrapeException;
import ningenme.net.api.compro.domain.repository.AtcoderUserAtcoderRepository;
import ningenme.net.api.domain.value.AtcoderId;
import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class AtcoderUserAtcoderRepositoryImpl implements AtcoderUserAtcoderRepository {
  private final static String URL_RANKING_PAGE = "https://atcoder.jp/ranking";
  @Override
  public List<AtcoderUser> get(Integer pageNum) {
    try {
      Document document = Jsoup.connect(URL_RANKING_PAGE + "?page=" + pageNum).get();
      Elements elements = document.select("[class=username]").select("span");
      List<AtcoderUser> atcoderUserList = new ArrayList<>();
      for (Element element: elements) {
        AtcoderId atcoderId = AtcoderId.of(element.text());
        atcoderUserList.add(
                AtcoderUser
                        .builder()
                        .atcoderId(atcoderId)
                        .build()
        );
        log.info(atcoderId.getValue());
      }
      return atcoderUserList;
    }
    catch (Exception ex) {
      throw new ScrapeException(ex);
    }
  }

  @Override
  public Integer getAllPageNum() {
    Integer allPageNum = 0;
    try {
      Document document = Jsoup.connect(URL_RANKING_PAGE).get();
      Elements pageNumElements = document.select("[class=text-center]").select("a");
      for (Element element: pageNumElements) {
        if(NumberUtils.isNumber(element.text())) {
          allPageNum = Integer.max(allPageNum, Integer.valueOf(element.text()));
        }
      }
    }
    catch (Exception ex) {
      throw new ScrapeException(ex);
    }
    return allPageNum;
  }
}
