package ningenme.net.api.application.controller.comproCategoryTopic.getOneWithTask;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.controller.comproCategoryTask.getList.ComproCategoryTopicResponseDto;
import ningenme.net.api.domain.entity.ComproCategoryTask;

import java.util.List;
import java.util.stream.Collectors;

/**
 * レスポンス時のDTO, プリミティブ型のメンバのみで構成する
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTopicGetOneWithTaskComproCategoryTaskResponseDto")
public class ComproCategoryTaskResponseDto {
  private final String taskId;
  private final String taskName;
  private final String url;
  private final Integer score;
  private final Integer estimation;

  public static ComproCategoryTaskResponseDto of(ComproCategoryTask comproCategoryTask) {
    return new ComproCategoryTaskResponseDto(
            comproCategoryTask.getTaskId(),
            comproCategoryTask.getTaskName(),
            comproCategoryTask.getUrl().getValue(),
            comproCategoryTask.getScore().getValue(),
            comproCategoryTask.getEstimation().getValue()
    );
  }
}
