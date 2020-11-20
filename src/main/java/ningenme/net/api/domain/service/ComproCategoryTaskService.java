package ningenme.net.api.domain.service;

import ningenme.net.api.domain.entity.ComproCategoryTask;

import java.util.List;

public interface ComproCategoryTaskService {
  public List<ComproCategoryTask> getList(Integer offset);
  public ComproCategoryTask getOne(String taskId);
  public Integer getCount();
  public void post(ComproCategoryTask comproCategoryTask);
  public void put(ComproCategoryTask comproCategoryTask);
}
