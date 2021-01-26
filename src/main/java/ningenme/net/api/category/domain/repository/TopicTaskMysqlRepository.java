package ningenme.net.api.category.domain.repository;

import ningenme.net.api.category.domain.entity.TopicTask;

import java.util.List;

public interface TopicTaskMysqlRepository {
  public void postList(List<TopicTask> topicTaskList);
  public void deleteByTaskId(String taskId);
}
