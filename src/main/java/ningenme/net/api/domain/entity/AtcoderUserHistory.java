package ningenme.net.api.domain.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.*;

@Getter
@RequiredArgsConstructor
public class AtcoderUserHistory {
  @NonNull
  private final AtcoderId atcoderId;
  @NonNull
  private final ContestId contestId;

  private final Boolean isRated;
  private final Place place;
  private final Rate oldRate;
  private final Rate newRate;
  private final Performance performance;
  public static AtcoderUserHistory of(
          AtcoderId atcoderId,
          ContestId contestId,
          Boolean isRated,
          Place place,
          Rate oldRate,
          Rate newRate,
          Performance performance
  ) {
    return new AtcoderUserHistory(atcoderId,contestId,isRated,place,oldRate,newRate,performance);
  }
}
