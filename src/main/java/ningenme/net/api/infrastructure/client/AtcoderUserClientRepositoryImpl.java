package ningenme.net.api.infrastructure.client;

import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.AtcoderUser;
import ningenme.net.api.domain.exception.ScrapeException;
import ningenme.net.api.domain.repository.AtcoderUserClientRepository;
import ningenme.net.api.domain.value.AtcoderId;
import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Repository
@Slf4j
public class AtcoderUserClientRepositoryImpl implements AtcoderUserClientRepository {
  private final static String URL_RANKING_PAGE = "https://atcoder.jp/ranking";
  private static final Pattern PAGE_NUM_REGEX_PATTERN = Pattern.compile(".*ranking\\?page=.*");
  @Override
  public List<AtcoderUser> get(Integer pageNum) {
    try {
      Document document = Jsoup.connect(URL_RANKING_PAGE + "?page=" + pageNum).get();
      Elements elements = document.select("[class=username]").select("span");
      List<AtcoderUser> atcoderUserList = new ArrayList<>();
      for (Element element: elements) {
        AtcoderId atcoderId = AtcoderId.of(element.text());
        atcoderUserList.add(AtcoderUser.of(atcoderId));
        log.info(atcoderId.getValue());
      }
      return atcoderUserList;
    }
    catch (Exception ex) {
      throw new ScrapeException(ex);
    }
  }

  @Override
  public AtcoderUser getOne(AtcoderId atcoderId) {
    return null;
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
