package ningenme.net.api.category.infrastructure.mysql.dto;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTask;
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
  public ComproCategoryTask convertComproCategoryTask() {
    return ComproCategoryTask.of(
            taskId,
            taskName,
            Url.of(url),
            TaskScore.of(score),
            TaskScore.of(estimation),
            topicIds,
            createdTime
    );
  }
  public static TaskMysqlDto of(ComproCategoryTask comproCategoryTask) {
    return new TaskMysqlDto(
            comproCategoryTask.getTaskId(),
            comproCategoryTask.getTaskName(),
            comproCategoryTask.getUrl().getValue(),
            comproCategoryTask.getScore().getValue(),
            comproCategoryTask.getEstimation().getValue(),
            null,
            String.join(",", comproCategoryTask.getTopicIdList()),
            null,
            null,
            null
    );
  }
}
