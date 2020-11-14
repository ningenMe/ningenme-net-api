package ningenme.net.api.domain.service;

import ningenme.net.api.domain.entity.ComproTask;
import ningenme.net.api.domain.value.Url;

public interface ComproTaskService {
  public ComproTask get(Url url);
}
