package ningenme.net.api.category.application.controller.comproCategoryGenreListWithTopicGet.view;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTopic;

/**
 * レスポンス時のDTO, プリミティブ型のメンバのみで構成する
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetOneWithTopicComproCategoryTopicResponseDto")
public class ComproCategoryTopicView {
  private final String topicId;
  private final String topicName;
  private final Integer topicOrder;
  public static ComproCategoryTopicView of(ComproCategoryTopic comproCategoryTopic) {
    return new ComproCategoryTopicView(
            comproCategoryTopic.getTopicId(),
            comproCategoryTopic.getTopicName(),
            comproCategoryTopic.getTopicOrder().getValue()
    );
  }
}
