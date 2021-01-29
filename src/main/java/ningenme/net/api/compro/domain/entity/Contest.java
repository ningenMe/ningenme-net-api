package ningenme.net.api.compro.domain.entity;

import lombok.*;
import ningenme.net.api.compro.domain.value.*;
import ningenme.net.api.util.domain.value.Url;

@Getter
@Builder
public class Contest {
  @NonNull
  private final ComproSite comproSite;
  @NonNull
  private final ContestId contestId;

  private final ContestName contestName;
  private final Url url;
  private final StartTime startTime;
  private final EndTime endTime;
}
