package ningenme.net.api.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.ComproSite;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.TaskUniqueId;
import ningenme.net.api.domain.value.Url;

import java.util.Optional;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ComproTask {
  private final TaskUniqueId taskUniqueId;
  @NonNull
  private final String taskName;
  @NonNull
  private final Url url;
  @NonNull
  private final TaskScore taskScore;
  @NonNull
  private final ComproSite comproSite;

  public static ComproTask of(
          TaskUniqueId taskUniqueId,
          String taskName,
          @NonNull
          Url url,
          TaskScore taskScore,
          @NonNull
          ComproSite comproSite
  ){
    return new ComproTask(taskUniqueId,
            Optional.ofNullable(taskName).orElse(""),
            url,
            Optional.ofNullable(taskScore).orElse(TaskScore.of(0)),
            comproSite);
  }
}
