package ningenme.net.api.infrastructure.client;

import ningenme.net.api.domain.entity.ComproSite;
import ningenme.net.api.domain.entity.ComproTask;
import ningenme.net.api.domain.exception.ScrapeException;
import ningenme.net.api.domain.repository.ComproCodeforcesTaskClientRepository;
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
      return ComproTask.of( TaskUniqueId.of(), taskName, url, null, ComproSite.CODEFORCES);
    }
    catch (Exception ex) {
      throw new ScrapeException(ex);
    }
  }
}
