package ningenme.net.api.infrastructure.mysql.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.AtcoderUser;
import ningenme.net.api.domain.value.*;

import java.sql.Timestamp;

@Getter
@Builder
public class AtcoderUserMysqlDto {
  private final String atcoderId;
  private final String topcoderId;
  private final String codeforcesId;
  private final String yukicoderId;
  private final Integer rank;
  private final String country;
  private final String affiliation;
  private final Integer currentRate;
  private final Integer highestRate;
  private final Integer currentPerformance;
  private final Integer highestPerformance;
  private final Timestamp firstParticipate;
  private final Timestamp lastParticipate;
  private final Timestamp deletedTime;
  private final Timestamp createdTime;
  private final Timestamp updatedTime;

  public AtcoderUser convertAtcoderUser() {
    return AtcoderUser
            .builder()
            .atcoderId(AtcoderId.of(atcoderId))
            .updatedTime(updatedTime)
            .build();
  }
}
