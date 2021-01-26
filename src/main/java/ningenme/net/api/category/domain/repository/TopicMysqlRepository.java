package ningenme.net.api.category.domain.repository;

import ningenme.net.api.category.domain.entity.Topic;

import java.util.List;

public interface TopicMysqlRepository {
  public List<Topic> get();
  public Topic get(String topicId);
}
