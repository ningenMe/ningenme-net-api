package ningenme.net.api.infrastructure.dto;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTask;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.Url;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ComproCategoryTaskDto {
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
  public static ComproCategoryTaskDto of(ComproCategoryTask comproCategoryTask) {
    return new ComproCategoryTaskDto(
            comproCategoryTask.getTaskId(),
            comproCategoryTask.getTaskName(),
            comproCategoryTask.getUrl(),
            comproCategoryTask.getScore(),
            comproCategoryTask.getEstimation(),
            null,
            String.join(",", comproCategoryTask.getTopicIdList()),
            null,
            null,
            null
    );
  }
}
