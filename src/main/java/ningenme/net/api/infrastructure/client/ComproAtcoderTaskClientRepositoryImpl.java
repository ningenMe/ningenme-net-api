package ningenme.net.api.infrastructure.client;

import ningenme.net.api.domain.entity.ComproSite;
import ningenme.net.api.domain.entity.ComproTask;
import ningenme.net.api.domain.exception.ScrapeException;
import ningenme.net.api.domain.repository.ComproAtcoderTaskClientRepository;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.TaskUniqueId;
import ningenme.net.api.domain.value.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import java.util.regex.Pattern;

@Repository
public class ComproAtcoderTaskClientRepositoryImpl implements ComproAtcoderTaskClientRepository {

  private static final Pattern TASK_SCORE_REGEX_PATTERN = Pattern.compile(".*配点 : .*");

  @Override
  public ComproTask get(Url url) {
    try {
      Document document = Jsoup.connect(url.getValue()).get();
      Elements taskNameElements  = document.select("title");
      Elements taskScoreElements = document.getElementsMatchingOwnText(TASK_SCORE_REGEX_PATTERN).select("var");

      String taskName   = taskNameElements.text();
      String taskScore = taskScoreElements.text();
      return ComproTask.of( TaskUniqueId.of(), taskName, url, TaskScore.of(taskScore), ComproSite.ATCODER);
    }
    catch (Exception ex) {
      throw new ScrapeException(ex);
    }
  }
}
