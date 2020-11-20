package ningenme.net.api.domain.repository;

import ningenme.net.api.domain.entity.ComproCategoryTopic;
import ningenme.net.api.domain.entity.ComproCategoryTopicTask;

import java.util.List;

public interface ComproCategoryTopicTaskRepository {
  public void postList(List<ComproCategoryTopicTask> comproCategoryTopicTaskList);
  public void deleteByTaskId(String taskId);
}
