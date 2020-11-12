package ningenme.net.api.domain.repository;

import ningenme.net.api.domain.entity.ComproCategoryTask;

import java.util.List;

public interface ComproCategoryTaskRepository {
  public List<ComproCategoryTask> get(Integer offset);
}
