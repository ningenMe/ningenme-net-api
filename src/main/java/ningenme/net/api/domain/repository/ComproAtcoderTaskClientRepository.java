package ningenme.net.api.domain.repository;

import ningenme.net.api.domain.entity.ComproTask;
import ningenme.net.api.domain.value.Url;

public interface ComproAtcoderTaskClientRepository {
  public ComproTask get(Url url);
}
