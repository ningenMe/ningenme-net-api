package ningenme.net.api.domain.service;

import ningenme.net.api.domain.entity.ComproCategoryTask;

import java.util.List;

public interface ComproCategoryTaskService {
  public List<ComproCategoryTask> getList(Integer offset);
  public ComproCategoryTask getOne(Integer taskId);
}
