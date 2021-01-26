package ningenme.net.api.category.domain.service;

import ningenme.net.api.category.domain.entity.Task;

import java.util.List;

public interface TaskService {
  public List<Task> getList(Integer offset);
  public Task getOne(String taskId);
  public Integer getCount();
  public void post(Task task);
  public void put(Task task);
}
