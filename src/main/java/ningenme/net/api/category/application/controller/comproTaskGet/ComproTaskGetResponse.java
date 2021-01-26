package ningenme.net.api.category.application.controller.comproTaskGet;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.application.controller.comproTaskGet.view.ComproTaskView;
import ningenme.net.api.compro.domain.entity.Task;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ComproTaskGetResponse {
  private final ComproTaskView comproTask;
  public static ComproTaskGetResponse of(Task task) {
    return new ComproTaskGetResponse(ComproTaskView.of(task));
  }
}
