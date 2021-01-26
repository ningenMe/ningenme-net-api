package ningenme.net.api.category.infrastructure.mysql.dto;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Task;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.Url;

import java.sql.Timestamp;

@RequiredArgsConstructor
public class TaskMysqlDto {
  private final String taskId;
  private final String taskName;
  private final String url;
  private final Integer score;
  private final Integer estimation;
  private final String site;
  private final String topicIds;
  private final Timestamp createdTime;
  private final Timestamp updatedTime;
  private final Timestamp deletedTime;
  public Task convertComproCategoryTask() {
    return Task.of(
            taskId,
            taskName,
            Url.of(url),
            TaskScore.of(score),
            TaskScore.of(estimation),
            topicIds,
            createdTime
    );
  }
  public static TaskMysqlDto of(Task task) {
    return new TaskMysqlDto(
            task.getTaskId(),
            task.getTaskName(),
            task.getUrl().getValue(),
            task.getScore().getValue(),
            task.getEstimation().getValue(),
            null,
            String.join(",", task.getTopicIdList()),
            null,
            null,
            null
    );
  }
}
