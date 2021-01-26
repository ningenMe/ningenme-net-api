package ningenme.net.api.compro.domain.entity;

import lombok.*;
import ningenme.net.api.compro.domain.value.ComproSite;
import ningenme.net.api.compro.domain.value.TaskScore;
import ningenme.net.api.category.domain.value.TaskUniqueId;
import ningenme.net.api.util.domain.value.Url;

@Getter
@Builder
public class Task {
  @NonNull
  private final TaskUniqueId taskUniqueId;
  @NonNull
  private final String taskName;
  @NonNull
  private final Url url;
  @NonNull
  private final TaskScore taskScore;
  @NonNull
  private final ComproSite comproSite;
}
