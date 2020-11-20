package ningenme.net.api.application.controller.comproCategoryGenre.getListWithTopic.getList;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.controller.comproCategoryGenre.getOneWithTopic.ComproCategoryTaskResponseDto;
import ningenme.net.api.domain.entity.ComproCategoryTopic;

import java.util.List;
import java.util.stream.Collectors;

/**
 * レスポンス時のDTO, プリミティブ型のメンバのみで構成する
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetOneWithTopicComproCategoryTopicResponseDto")
public class ComproCategoryTopicResponseDto {
  private final String topicId;
  private final String topicName;
  private final Integer topicOrder;
  public static ComproCategoryTopicResponseDto of(ComproCategoryTopic comproCategoryTopic) {
    return new ComproCategoryTopicResponseDto(
            comproCategoryTopic.getTopicId(),
            comproCategoryTopic.getTopicName(),
            comproCategoryTopic.getTopicOrder().getValue()
    );
  }
}
