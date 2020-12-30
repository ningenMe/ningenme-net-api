package ningenme.net.api.infrastructure.client;

import ningenme.net.api.domain.entity.ComproTask;
import ningenme.net.api.domain.repository.ComproAojBetaTaskClientRepository;
import ningenme.net.api.domain.value.Url;
import org.springframework.stereotype.Repository;

@Repository
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
