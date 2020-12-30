package ningenme.net.api.domain.entity;

import lombok.*;
import ningenme.net.api.domain.value.ComproSite;
import ningenme.net.api.domain.value.ContestId;
import ningenme.net.api.domain.value.ContestName;
import ningenme.net.api.domain.value.Url;

import java.sql.Timestamp;

@Getter
@Builder
public class ComproContest {
  @NonNull
  private final ComproSite comproSite;
  @NonNull
  private final ContestId contestId;

  private final ContestName contestName;
  private final Url url;
  private final Timestamp startTime;
  private final Timestamp endTime;
}
