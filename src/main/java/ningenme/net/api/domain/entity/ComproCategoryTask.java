package ningenme.net.api.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.Url;

import java.sql.Timestamp;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ComproCategoryTask {
  @NonNull
  private final Integer taskId;
  @NonNull
  private final String taskName;
  private final Url url;
  @NonNull
  private final TaskScore score;
  @NonNull
  private final TaskScore estimation;
  private final Timestamp createdTime;
  public static ComproCategoryTask of(
          Integer taskId,
          String taskName,
          Url url,
          TaskScore score,
          TaskScore estimation,
          Timestamp createdTime
  ) {
    return new ComproCategoryTask(taskId,taskName,url,score,estimation,createdTime);
  }
  public String getUrl() {
    return url.getValue();
  }
  public Integer getScore() {
    return score.getValue();
  }
  public Integer getEstimation() {
    return estimation.getValue();
  }
  public String getCreatedTime() {
    return createdTime.toString();
  }
}
