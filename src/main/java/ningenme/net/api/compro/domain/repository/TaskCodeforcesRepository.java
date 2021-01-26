package ningenme.net.api.compro.domain.repository;

import ningenme.net.api.compro.domain.entity.Task;
import ningenme.net.api.util.domain.value.Url;

public interface TaskCodeforcesRepository {
  public Task get(Url url);
}
