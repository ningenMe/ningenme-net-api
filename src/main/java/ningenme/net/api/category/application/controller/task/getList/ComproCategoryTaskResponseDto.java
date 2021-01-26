package ningenme.net.api.category.application.controller.task.getList;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Task;

import java.util.List;
import java.util.stream.Collectors;

/**
 * レスポンス時のDTO, プリミティブ型のメンバのみで構成する
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTaskGetListComproCategoryTaskResponseDto")
public class ComproCategoryTaskResponseDto {
  private final String taskId;
  private final String taskName;
  private final String url;
  private final Integer score;
  private final Integer estimation;
  private final List<ComproCategoryTopicResponseDto> comproCategoryTopicList;

  public static ComproCategoryTaskResponseDto of(Task task) {
    return new ComproCategoryTaskResponseDto(
            task.getTaskId(),
            task.getTaskName(),
            task.getUrl().getValue(),
            task.getScore().getValue(),
            task.getEstimation().getValue(),
            task
                    .getTopicList()
                    .stream()
                    .map(
                            comproCategoryTopic -> ComproCategoryTopicResponseDto.of(comproCategoryTopic)
                    )
                    .collect(Collectors.toList())
    );
  }
}
