package ningenme.net.api.application.controller.comproCategoryGenre.getOneWithTopic;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTask;

/**
 * レスポンス時のDTO, プリミティブ型のメンバのみで構成する
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetOneWithTopicComproCategoryTaskResponseDto")
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
