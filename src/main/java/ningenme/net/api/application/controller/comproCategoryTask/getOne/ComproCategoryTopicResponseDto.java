package ningenme.net.api.application.controller.comproCategoryTask.getOne;

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
@ApiModel(value = "ComproCategoryTaskGetOneComproCategoryTopicResponseDto")
public class ComproCategoryTopicResponseDto {
  private final String topicId;
  private final String topicName;
  public static ComproCategoryTopicResponseDto of(ComproCategoryTopic comproCategoryTopic) {
    return new ComproCategoryTopicResponseDto(
            comproCategoryTopic.getTopicId(),
            comproCategoryTopic.getTopicName()
    );
  }
}
