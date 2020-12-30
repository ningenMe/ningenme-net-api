package ningenme.net.api.infrastructure.client;

import ningenme.net.api.domain.entity.ComproSite;
import ningenme.net.api.domain.entity.ComproTask;
import ningenme.net.api.domain.exception.ScrapeException;
import ningenme.net.api.domain.repository.ComproYukicoderTaskClientRepository;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.TaskUniqueId;
import ningenme.net.api.domain.value.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

@Repository
public class ComproYukicoderTaskClientRepositoryImpl implements ComproYukicoderTaskClientRepository {

  @Override
  public ComproTask get(Url url) {
    try {
      Document document = Jsoup.connect(url.getValue()).get();
      Elements taskNameElements  = document.select("title");
      Integer taskScoreOneStarCount  = document.select("[class=fas fa-star]").size();
      Integer taskScoreHalfStarCount = document.select("[class=fas fa-star-half]").size();

      String taskName   = taskNameElements.text();
      Integer taskScore = taskScoreOneStarCount*100 + taskScoreHalfStarCount*50;
      return ComproTask.of( TaskUniqueId.of(), taskName, url, TaskScore.of(taskScore), ComproSite.YUKICODER);
    }
    catch (Exception ex) {
      throw new ScrapeException(ex);
    }
  }
}
