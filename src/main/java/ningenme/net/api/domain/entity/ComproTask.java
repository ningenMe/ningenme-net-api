package ningenme.net.api.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.TaskUniqueId;
import ningenme.net.api.domain.value.Url;

import java.util.Objects;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ComproTask {
  private final TaskUniqueId taskUniqueId;
  private final String taskName;
  private final Url url;
  private final TaskScore taskScore;
  private final ComproSite comproSite;

  public static ComproTask of(
          TaskUniqueId taskUniqueId,

          @NonNull
          String taskName,

          @NonNull
          Url url,

          TaskScore taskScore,

          @NonNull
          ComproSite comproSite
  ){
    return new ComproTask(taskUniqueId,taskName,url,taskScore,comproSite);
  }

  public String getTaskUniqueId() {
    return Objects.isNull(taskUniqueId) ? null : taskUniqueId.getValue().toString();
  }
  public String getUrl() {
    return url.getValue();
  }
  public Integer getTaskScore() {
    return Objects.isNull(taskScore) ? null : taskScore.getValue();
  }
  public String getComproSite() {
    return comproSite.getContestName();
  }
}
