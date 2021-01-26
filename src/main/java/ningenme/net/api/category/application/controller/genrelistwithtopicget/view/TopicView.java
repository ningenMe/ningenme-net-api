package ningenme.net.api.category.application.controller.genrelistwithtopicget.view;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Topic;

/**
 * レスポンス時のDTO, プリミティブ型のメンバのみで構成する
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetOneWithTopicComproCategoryTopicResponseDto")
public class TopicView {
  private final String topicId;
  private final String topicName;
  private final Integer topicOrder;
  public static TopicView of(Topic topic) {
    return new TopicView(
            topic.getTopicId(),
            topic.getTopicName(),
            topic.getTopicOrder().getValue()
    );
  }
}
