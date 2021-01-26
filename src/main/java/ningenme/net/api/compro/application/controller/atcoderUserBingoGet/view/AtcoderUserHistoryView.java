package ningenme.net.api.compro.application.controller.atcoderUserBingoGet.view;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.compro.domain.entity.AtcoderUserHistory;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AtcoderUserHistoryView {
  private final String atcoderId;
  private final String contestId;
  private final String contestName;
  private final String url;
  private final Integer place;
  private final Integer performance;

  public static AtcoderUserHistoryView of(AtcoderUserHistory atcoderUserHistory) {
    return new AtcoderUserHistoryView(
            atcoderUserHistory.getAtcoderId().getValue(),
            atcoderUserHistory.getContestId().getValue(),
            "",
            atcoderUserHistory.getUrl().getValue(),
            atcoderUserHistory.getPlace().getValue(),
            atcoderUserHistory.getPerformance().getValue()
    );
  }
}
