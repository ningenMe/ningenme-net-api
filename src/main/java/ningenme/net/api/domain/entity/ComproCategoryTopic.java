package ningenme.net.api.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.CategoryOrder;
import ningenme.net.api.domain.value.Label;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ComproCategoryTopic {
  @NonNull
  private final Integer topicId;
  @NonNull
  private final Integer genreId;
  @NonNull
  private final String topicName;
  @NonNull
  private final CategoryOrder topicOrder;

  public static ComproCategoryTopic of(
          Integer topicId,
          Integer genreId,
          String topicName,
          CategoryOrder topicOrder
  ) {
    return new ComproCategoryTopic(topicId, genreId,topicName,topicOrder);
  }
  public Integer getTopicOrder() {
    return topicOrder.getValue();
  }
}
