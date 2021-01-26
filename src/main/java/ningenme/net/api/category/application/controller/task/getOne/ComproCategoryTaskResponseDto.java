package ningenme.net.api.category.application.controller.task.getOne;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.application.controller.task.getList.ComproCategoryTopicResponseDto;
import ningenme.net.api.domain.entity.ComproCategoryTask;

import java.util.List;
import java.util.stream.Collectors;

/**
 * レスポンス時のDTO, プリミティブ型のメンバのみで構成する
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTaskGetOneComproCategoryTaskResponseDto ")
public class ComproCategoryTaskResponseDto {
  private final String taskId;
  private final String taskName;
  private final String url;
  private final Integer score;
  private final Integer estimation;
  private final List<String> topicIdList;
  private final List<ComproCategoryTopicResponseDto> comproCategoryTopicList;

  public static ComproCategoryTaskResponseDto of(ComproCategoryTask comproCategoryTask) {
    return new ComproCategoryTaskResponseDto(
            comproCategoryTask.getTaskId(),
            comproCategoryTask.getTaskName(),
            comproCategoryTask.getUrl().getValue(),
            comproCategoryTask.getScore().getValue(),
            comproCategoryTask.getEstimation().getValue(),
            comproCategoryTask.getTopicIdList(),
            comproCategoryTask
                    .getComproCategoryTopicList()
                    .stream()
                    .map(
                            comproCategoryTopic -> ComproCategoryTopicResponseDto.of(comproCategoryTopic)
                    )
                    .collect(Collectors.toList())
    );
  }
}
