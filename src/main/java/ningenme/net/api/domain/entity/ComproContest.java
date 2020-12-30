package ningenme.net.api.domain.entity;

import lombok.*;
import ningenme.net.api.domain.value.*;

@Getter
@Builder
public class ComproContest {
  @NonNull
  private final ComproSite comproSite;
  @NonNull
  private final ContestId contestId;

  private final ContestName contestName;
  private final Url url;
  private final StartTime startTime;
  private final EndTime endTime;
}
