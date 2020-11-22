package ningenme.net.api.application.controller.comproTask.getOne;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproTask;

/**
 * レスポンス時のDTO, プリミティブ型のメンバのみで構成する
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTaskGetOneComproCategoryTaskResponseDto ")
public class ComproTaskResponseDto {
  private final String taskUniqueId;
  private final String name;
  private final Integer score;
  private final String url;
  private final String site;

  public static ComproTaskResponseDto of(ComproTask comproTask) {
    return new ComproTaskResponseDto(
            comproTask.getTaskUniqueId().getValue().toString(),
            comproTask.getTaskName(),
            comproTask.getTaskScore().getValue(),
            comproTask.getUrl().getValue(),
            comproTask.getComproSite().getSiteId()
    );
  }
}
