package ningenme.net.api.application.controller.comproSiteUserBingoGet;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.controller.comproSiteUserBingoGet.view.AtcoderUserHistoryView;
import ningenme.net.api.domain.entity.AtcoderUserHistory;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ComproSiteUserBingoGetResponse {
  private final List<AtcoderUserHistoryView> atcoderUserHistoryViews;

  public static ComproSiteUserBingoGetResponse of(List<AtcoderUserHistory> atcoderUserHistories) {
    return new ComproSiteUserBingoGetResponse(
            atcoderUserHistories
                    .stream()
                    .map(atcoderUserHistory -> AtcoderUserHistoryView.of(atcoderUserHistory))
                    .collect(Collectors.toList())
    );
  }
}
