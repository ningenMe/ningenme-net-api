package ningenme.net.api.category.application.controller.topic.getOneWithTask;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Topic;

import java.util.List;
import java.util.stream.Collectors;

/**
 * レスポンス時のDTO, プリミティブ型のメンバのみで構成する
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTopicGetOneWithTaskComproCategoryTopicResponseDto")
public class ComproCategoryTopicResponseDto {
  private final String topicId;
  private final String topicName;
  private final Integer topicOrder;
  private final String genreId;
  private final String genreName;
  private final List<ComproCategoryTaskResponseDto> comproCategoryTaskList;
  public static ComproCategoryTopicResponseDto of(Topic topic) {
    return new ComproCategoryTopicResponseDto(
            topic.getTopicId(),
            topic.getTopicName(),
            topic.getTopicOrder().getValue(),
            topic.getGenreId(),
            topic.getGenreName(),
            topic.getTaskList()
                    .stream()
                    .map(comproCategoryTask -> ComproCategoryTaskResponseDto.of(comproCategoryTask))
                    .collect(Collectors.toList())
    );
  }
}
