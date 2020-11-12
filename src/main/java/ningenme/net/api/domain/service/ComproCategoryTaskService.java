package ningenme.net.api.domain.service;

import ningenme.net.api.domain.entity.ComproCategoryTask;

import java.util.List;

public interface ComproCategoryTaskService {
  public List<ComproCategoryTask> get(Integer offset);
}
