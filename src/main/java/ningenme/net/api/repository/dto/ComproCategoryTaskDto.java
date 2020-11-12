package ningenme.net.api.repository.dto;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTask;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.Url;

import java.sql.Timestamp;

@RequiredArgsConstructor
public class ComproCategoryTaskDto {
  private final Integer taskId;
  private final String taskName;
  private final String url;
  private final Integer score;
  private final Integer estimation;
  private final String site;
  private final Timestamp createdTime;
  private final Timestamp updatedTime;
  private final Timestamp deletedTime;
  public ComproCategoryTask convertComproCategoryTask() {
    return ComproCategoryTask.of(
            taskId,taskName,
            Url.of(url),
            TaskScore.of(score),
            TaskScore.of(estimation),
            createdTime
    );
  }
}
