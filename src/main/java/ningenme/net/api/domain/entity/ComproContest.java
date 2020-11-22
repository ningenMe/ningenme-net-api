package ningenme.net.api.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.ContestId;
import ningenme.net.api.domain.value.ContestName;
import ningenme.net.api.domain.value.Url;

import java.sql.Timestamp;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ComproContest {
  @NonNull
  private final ComproSite comproSite;
  @NonNull
  private final ContestId contestId;

  private final ContestName contestName;
  private final Url url;
  private final Timestamp startTime;
  private final Timestamp endTime;

  public static ComproContest of(
    ComproSite comproSite,
    ContestId contestId,
    ContestName contestName,
    Url url,
    Timestamp startTime,
    Timestamp endTime
  ){
    return new ComproContest(
            comproSite,contestId,contestName,url,startTime,endTime
    );
  }
}
