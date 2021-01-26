package ningenme.net.api.compro.application.controller.taskget;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.compro.application.controller.taskget.view.ComproTaskView;
import ningenme.net.api.compro.domain.entity.Task;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskGetResponse {
  private final ComproTaskView comproTask;
  public static TaskGetResponse of(Task task) {
    return new TaskGetResponse(ComproTaskView.of(task));
  }
}
