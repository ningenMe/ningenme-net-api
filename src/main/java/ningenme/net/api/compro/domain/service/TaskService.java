package ningenme.net.api.compro.domain.service;

import ningenme.net.api.compro.domain.entity.Task;
import ningenme.net.api.domain.value.Url;

public interface TaskService {
  public Task get(Url url);
}
