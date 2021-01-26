package ningenme.net.api.domain.repository;

import ningenme.net.api.category.domain.entity.Task;
import ningenme.net.api.domain.value.Url;

import java.util.List;

public interface ComproCategoryTaskRepository {
  public List<Task> getList(Integer offset);
  public List<Task> getListByTopicId(String topicId);
  public Task getOne(String taskId);
  public Integer getCountByUrl(Url url);
  public Integer getCount();
  public void post(Task task);
  public void put(Task task);
}
