package ningenme.net.api.application.controller.comproAtCoderUserBingoGet.view;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.AtcoderUserHistory;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AtcoderUserHistoryView {
  private final String atcoderId;
  private final String contestId;
  private final String url;
  private final Integer place;

  public static AtcoderUserHistoryView of(AtcoderUserHistory atcoderUserHistory) {
    return new AtcoderUserHistoryView(
            atcoderUserHistory.getAtcoderId().getValue(),
            atcoderUserHistory.getContestId().getValue(),
            atcoderUserHistory.getUrl().getValue(),
            atcoderUserHistory.getPlace().getValue()
    );
  }
}