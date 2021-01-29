package ningenme.net.api.compro.infrastructure.codeforces;

import ningenme.net.api.compro.domain.value.ComproSite;
import ningenme.net.api.compro.domain.entity.Task;
import ningenme.net.api.util.domain.exception.ScrapeException;
import ningenme.net.api.compro.domain.repository.TaskCodeforcesRepository;
import ningenme.net.api.compro.domain.value.TaskScore;
import ningenme.net.api.category.domain.value.TaskUniqueId;
import ningenme.net.api.util.domain.value.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

@Repository
public class TaskCodeforcesRepositoryImpl implements TaskCodeforcesRepository {

  @Override
  public Task get(Url url) {
    try {
      Document document = Jsoup.connect(url.getValue()).get();
      Elements taskNameElements  = document.select("[class=header]").select("[class=title]");

      String taskName   = taskNameElements.text();
      return Task.builder()
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
