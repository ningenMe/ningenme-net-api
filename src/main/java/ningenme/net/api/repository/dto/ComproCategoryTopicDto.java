package ningenme.net.api.repository.dto;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;
import ningenme.net.api.domain.entity.ComproCategoryTopic;
import ningenme.net.api.domain.value.CategoryOrder;
import ningenme.net.api.domain.value.Label;

@RequiredArgsConstructor
public class ComproCategoryTopicDto {
  private final Integer topicId;
  private final Integer genreId;
  private final String topicName;
  private final Integer topicOrder;
  public ComproCategoryTopic convertComproCategoryTopic() {
    return ComproCategoryTopic.of(
            topicId,
            genreId,
            topicName,
            CategoryOrder.of(topicOrder)
    );
  }
}
