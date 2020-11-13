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
  private final Integer taskId;
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
            taskId,taskName,
            Url.of(url),
            TaskScore.of(score),
            TaskScore.of(estimation),
            Arrays.asList(topicIds.split(","))
                    .stream()
                    .map(topicId -> Integer.parseInt(topicId))
                    .collect(Collectors.toList())
            ,
            createdTime
    );
  }
}
