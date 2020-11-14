package ningenme.net.api.infrastructure.client;

import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.ComproSite;
import ningenme.net.api.domain.entity.ComproTask;
import ningenme.net.api.domain.exception.ScrapeException;
import ningenme.net.api.domain.repository.ComproAojBetaTaskClientRepository;
import ningenme.net.api.domain.repository.ComproAojTaskClientRepository;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.TaskUniqueId;
import ningenme.net.api.domain.value.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class ComproAojBetaTaskClientRepositoryImpl implements ComproAojBetaTaskClientRepository {

  @Override
  public ComproTask get(Url url) {
    //TODO ロジックをそのうち書く or ここだけDBでまかなうべき
//    try {
//      Document document = Jsoup.connect(url.getValue()).get();
//    }
//    catch (Exception ex) {
//      throw new ScrapeException(ex);
//    }
    return null;
  }
}
