package ningenme.net.api.compro.domain.entity;

import lombok.*;
import ningenme.net.api.compro.domain.value.*;
import ningenme.net.api.util.domain.value.UpdatedTime;

@Getter
@Builder
public class AtcoderUser {
  @NonNull
  private final AtcoderId atcoderId;
  private final Rank rank;
  private final Country country;
  private final Affiliation affiliation;
  private final Rate currentRate;
  private final Rate highestRate;
  private final UpdatedTime updatedTime;
}
