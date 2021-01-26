package ningenme.net.api.compro.infrastructure.atcoder;

import ningenme.net.api.domain.value.ComproSite;
import ningenme.net.api.compro.domain.entity.Task;
import ningenme.net.api.util.domain.exception.ScrapeException;
import ningenme.net.api.compro.domain.repository.TaskAtcoderRepository;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.TaskUniqueId;
import ningenme.net.api.domain.value.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import java.util.regex.Pattern;

@Repository
public class TaskAtcoderRepositoryImpl implements TaskAtcoderRepository {

  private static final Pattern TASK_SCORE_REGEX_PATTERN = Pattern.compile(".*配点 : .*");

  @Override
  public Task get(Url url) {
    try {
      Document document = Jsoup.connect(url.getValue()).get();
      Elements taskNameElements  = document.select("title");
      Elements taskScoreElements = document.getElementsMatchingOwnText(TASK_SCORE_REGEX_PATTERN).select("var");

      String taskName   = taskNameElements.text();
      String taskScore = taskScoreElements.text();
      return Task.builder()
              .taskUniqueId(TaskUniqueId.of())
              .taskName(taskName)
              .url(url)
              .taskScore(TaskScore.of(taskScore))
              .comproSite(ComproSite.ATCODER)
              .build();
    }
    catch (Exception ex) {
      throw new ScrapeException(ex);
    }
  }
}
