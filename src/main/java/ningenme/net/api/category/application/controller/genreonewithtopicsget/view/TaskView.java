package ningenme.net.api.category.application.controller.genreonewithtopicsget.view;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Task;

/**
 * レスポンス時のDTO, プリミティブ型のメンバのみで構成する.
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskView {
  private final String taskId;
  private final String taskName;
  private final String url;
  private final Integer score;
  private final Integer estimation;

  public static TaskView of(Task task) {
    return new TaskView(
            task.getTaskId(),
            task.getTaskName(),
            task.getUrl().getValue(),
            task.getScore().getValue(),
            task.getEstimation().getValue()
    );
  }
}
