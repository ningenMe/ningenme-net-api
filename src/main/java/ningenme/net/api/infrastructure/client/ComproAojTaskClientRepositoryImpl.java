package ningenme.net.api.infrastructure.client;

import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.ComproSite;
import ningenme.net.api.domain.entity.ComproTask;
import ningenme.net.api.domain.exception.ScrapeException;
import ningenme.net.api.domain.repository.ComproAojTaskClientRepository;
import ningenme.net.api.domain.repository.ComproYukicoderTaskClientRepository;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.TaskUniqueId;
import ningenme.net.api.domain.value.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class ComproAojTaskClientRepositoryImpl implements ComproAojTaskClientRepository {

  @Override
  public ComproTask get(Url url) {
    try {
      Document document = Jsoup.connect(url.getValue()).get();
      Elements taskNameElements  = document.select("[id=page]").select("H1");
      String taskName   = taskNameElements.text();
      return ComproTask.of( TaskUniqueId.of(), taskName, url, null, ComproSite.ATCODER);
    }
    catch (Exception ex) {
      throw new ScrapeException(ex);
    }
  }
}
