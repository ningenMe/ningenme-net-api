package ningenme.net.api.domain.repository;

import ningenme.net.api.compro.domain.entity.Task;
import ningenme.net.api.domain.value.Url;

public interface ComproCodeforcesTaskClientRepository {
  public Task get(Url url);
}
