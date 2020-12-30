package ningenme.net.api.application.controller.comproSiteUserBingoGet.view;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.AtcoderUserHistory;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AtcoderUserHistoryView {
  private final String atcoderId;
  private final String contestId;
  private final Boolean isRated;
  private final Integer place;

  public static AtcoderUserHistoryView of(AtcoderUserHistory atcoderUserHistory) {
    return new AtcoderUserHistoryView(
            atcoderUserHistory.getAtcoderId().getValue(),
            atcoderUserHistory.getContestId().getValue(),
            atcoderUserHistory.getIsRated(),
            atcoderUserHistory.getPlace().getValue()
    );
  }
}
