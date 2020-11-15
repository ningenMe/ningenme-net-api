package ningenme.net.api.domain.repository;

import ningenme.net.api.domain.entity.ComproCategoryTopic;

import java.util.List;

public interface ComproCategoryTopicRepository {
  public List<ComproCategoryTopic> get();
  public ComproCategoryTopic get(String topicId);
}
