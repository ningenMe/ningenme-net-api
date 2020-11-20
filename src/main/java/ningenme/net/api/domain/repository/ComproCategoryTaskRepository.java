package ningenme.net.api.domain.repository;

import ningenme.net.api.domain.entity.ComproCategoryTask;
import ningenme.net.api.domain.value.Url;

import java.util.List;

public interface ComproCategoryTaskRepository {
  public List<ComproCategoryTask> getList(Integer offset);
  public List<ComproCategoryTask> getListByTopicId(String topicId);
  public ComproCategoryTask getOne(String taskId);
  public Integer getCountByUrl(Url url);
  public Integer getCount();
  public void post(ComproCategoryTask comproCategoryTask);
  public void put(ComproCategoryTask comproCategoryTask);
}
