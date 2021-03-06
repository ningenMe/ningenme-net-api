package ningenme.net.api.compro.infrastructure.yukicoder;

import ningenme.net.api.domain.value.ComproSite;
import ningenme.net.api.compro.domain.entity.Task;
import ningenme.net.api.util.domain.exception.ScrapeException;
import ningenme.net.api.compro.domain.repository.TaskYukicoderRepository;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.TaskUniqueId;
import ningenme.net.api.domain.value.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

@Repository
public class TaskYukicoderRepositoryImpl implements TaskYukicoderRepository {

  @Override
  public Task get(Url url) {
    try {
      Document document = Jsoup.connect(url.getValue()).get();
      Elements taskNameElements  = document.select("title");
      Integer taskScoreOneStarCount  = document.select("[class=fas fa-star]").size();
      Integer taskScoreHalfStarCount = document.select("[class=fas fa-star-half]").size();

      String taskName   = taskNameElements.text();
      Integer taskScore = taskScoreOneStarCount*100 + taskScoreHalfStarCount*50;
      return Task.builder()
              .taskUniqueId(TaskUniqueId.of())
              .taskName(taskName)
              .url(url)
              .taskScore(TaskScore.of(taskScore))
              .comproSite(ComproSite.YUKICODER)
              .build();
    }
    catch (Exception ex) {
      throw new ScrapeException(ex);
    }
  }
}
