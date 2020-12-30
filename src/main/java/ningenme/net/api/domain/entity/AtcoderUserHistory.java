package ningenme.net.api.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import ningenme.net.api.domain.value.*;

@Getter
@Builder
public class AtcoderUserHistory {

  private static final String CONTEST_URL = "https://atcoder.jp/contests/%s/standings?watching=%s";

  @NonNull
  private final AtcoderId atcoderId;
  @NonNull
  private final ContestId contestId;

  private final Boolean isRated;
  private final Place place;
  private final Rate oldRate;
  private final Rate newRate;
  private final Performance performance;

  public Url getUrl() {
    return Url.of(String.format(CONTEST_URL,contestId.getValue(),atcoderId.getValue()));
  }
}
