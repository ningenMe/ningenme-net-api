package ningenme.net.api.infrastructure.dto;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTopic;
import ningenme.net.api.domain.value.CategoryOrder;

@RequiredArgsConstructor
public class ComproCategoryTopicDto {
  private final String topicId;
  private final String genreId;
  private final String topicName;
  private final Integer topicOrder;
  public ComproCategoryTopic convertComproCategoryTopic() {
    return ComproCategoryTopic.of(
            topicId,
            topicName,
            CategoryOrder.of(topicOrder),
            genreId
    );
  }
}
