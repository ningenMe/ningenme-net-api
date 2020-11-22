package ningenme.net.api.infrastructure.mysql.dto;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.AtcoderUserHistory;

@RequiredArgsConstructor
public class AtcoderUserHistoryMysqlDto {
  private final String atcoderId;
  private final String contestId;
  private final Boolean isRated;
  private final Integer place;
  private final Integer oldRating;
  private final Integer newRating;
  private final Integer performance;

  public static AtcoderUserHistoryMysqlDto of(AtcoderUserHistory atcoderUserHistory) {
    return new AtcoderUserHistoryMysqlDto(
            atcoderUserHistory.getAtcoderId().getValue(),
            atcoderUserHistory.getContestId().getValue(),
            atcoderUserHistory.getIsRated(),
            atcoderUserHistory.getPlace().getValue(),
            atcoderUserHistory.getOldRate().getValue(),
            atcoderUserHistory.getNewRate().getValue(),
            atcoderUserHistory.getPerformance().getValue()
    );
  }
}
