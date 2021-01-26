package ningenme.net.api.domain.repository;

import ningenme.net.api.category.domain.entity.Topic;

import java.util.List;

public interface ComproCategoryTopicRepository {
  public List<Topic> get();
  public Topic get(String topicId);
}
