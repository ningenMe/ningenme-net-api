package ningenme.net.api.infrastructure.client;

import ningenme.net.api.domain.value.ComproSite;
import ningenme.net.api.domain.entity.ComproTask;
import ningenme.net.api.domain.exception.ScrapeException;
import ningenme.net.api.domain.repository.ComproCodeforcesTaskClientRepository;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.TaskUniqueId;
import ningenme.net.api.domain.value.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

@Repository
public class ComproCodeforcesTaskClientRepositoryImpl implements ComproCodeforcesTaskClientRepository {

  @Override
  public ComproTask get(Url url) {
    try {
      Document document = Jsoup.connect(url.getValue()).get();
      Elements taskNameElements  = document.select("[class=header]").select("[class=title]");

      String taskName   = taskNameElements.text();
      return ComproTask.builder()
              .taskUniqueId(TaskUniqueId.of())
              .taskName(taskName)
              .url(url)
              .taskScore(TaskScore.of(0))
              .comproSite(ComproSite.CODEFORCES)
              .build();
    }
    catch (Exception ex) {
      throw new ScrapeException(ex);
    }
  }
}
