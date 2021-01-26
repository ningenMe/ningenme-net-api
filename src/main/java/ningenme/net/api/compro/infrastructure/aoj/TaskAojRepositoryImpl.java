package ningenme.net.api.compro.infrastructure.aoj;

import ningenme.net.api.domain.value.ComproSite;
import ningenme.net.api.compro.domain.entity.Task;
import ningenme.net.api.util.domain.exception.ScrapeException;
import ningenme.net.api.compro.domain.repository.TaskAojRepository;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.TaskUniqueId;
import ningenme.net.api.domain.value.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

@Repository
public class TaskAojRepositoryImpl implements TaskAojRepository {

  @Override
  public Task get(Url url) {
    try {
      Document document = Jsoup.connect(url.getValue()).get();
      Elements taskNameElements  = document.select("[id=page]").select("H1");
      String taskName   = taskNameElements.text();
      return Task.builder()
              .taskUniqueId(TaskUniqueId.of())
              .taskName(taskName)
              .url(url)
              .taskScore(TaskScore.of(0))
              .comproSite(ComproSite.AOJ)
              .build();
    }
    catch (Exception ex) {
      throw new ScrapeException(ex);
    }
  }
}
