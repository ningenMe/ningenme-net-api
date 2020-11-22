package ningenme.net.api.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.*;

import java.sql.Timestamp;


@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AtcoderUser {
  @NonNull
  private final AtcoderId atcoderId;
  private final Rank rank;
  private final Country country;
  private final Affiliation affiliation;
  private final Rate currentRate;
  private final Rate highestRate;
  private final Timestamp updatedTime;
  public static AtcoderUser of(
          AtcoderId atcoderId,
          Rank rank,
          Country country,
          Affiliation affiliation,
          Rate currentRate,
          Rate highestRate,
          Timestamp updatedTime
  ){
    return new AtcoderUser(
            atcoderId,
            rank,
            country,
            affiliation,
            currentRate,
            highestRate,
            updatedTime
    );
  }
  public static AtcoderUser of(
          AtcoderId atcoderId
  ){
    return new AtcoderUser(
            atcoderId, null,null,null,null,null, null);
  }
}
