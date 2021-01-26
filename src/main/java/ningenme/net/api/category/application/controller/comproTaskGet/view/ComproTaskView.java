package ningenme.net.api.category.application.controller.comproTaskGet.view;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.compro.domain.entity.Task;

/**
 * レスポンス時のDTO, プリミティブ型のメンバのみで構成する
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTaskGetOneComproCategoryTaskResponseDto ")
public class ComproTaskView {
  private final String taskUniqueId;
  private final String name;
  private final Integer score;
  private final String url;
  private final String site;

  public static ComproTaskView of(Task task) {
    return new ComproTaskView(
            task.getTaskUniqueId().getValue().toString(),
            task.getTaskName(),
            task.getTaskScore().getValue(),
            task.getUrl().getValue(),
            task.getComproSite().getSiteId()
    );
  }
}
