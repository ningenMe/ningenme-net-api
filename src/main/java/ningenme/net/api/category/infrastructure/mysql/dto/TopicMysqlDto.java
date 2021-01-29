package ningenme.net.api.category.infrastructure.mysql.dto;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Topic;
import ningenme.net.api.category.domain.value.CategoryOrder;

@RequiredArgsConstructor
public class TopicMysqlDto {
  private final String topicId;
  private final String genreId;
  private final String topicName;
  private final Integer topicOrder;
  public Topic convertComproCategoryTopic() {
    return Topic.of(
            topicId,
            topicName,
            CategoryOrder.of(topicOrder),
            genreId
    );
  }
}
