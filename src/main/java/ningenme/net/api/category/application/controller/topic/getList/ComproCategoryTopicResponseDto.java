package ningenme.net.api.category.application.controller.topic.getList;

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
@ApiModel(value = "ComproCategoryTopicGetOneComproCategoryTopicResponseDto")
public class ComproCategoryTopicResponseDto {
  private final String topicId;
  private final String topicName;
  private final Integer topicOrder;
  private final String genreId;
  private final String genreName;
  public static ComproCategoryTopicResponseDto of(Topic topic) {
    return new ComproCategoryTopicResponseDto(
            topic.getTopicId(),
            topic.getTopicName(),
            topic.getTopicOrder().getValue(),
            topic.getGenreId(),
            topic.getGenreName()
    );
  }
}
