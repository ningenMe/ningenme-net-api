package ningenme.net.api.compro.infrastructure.mysql.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AtcoderUserHistoryMysqlDto {
  private final String atcoderId;
  private final String contestId;
  private final Boolean isRated;
  private final Integer place;
  private final Integer oldRating;
  private final Integer newRating;
  private final Integer performance;
}
