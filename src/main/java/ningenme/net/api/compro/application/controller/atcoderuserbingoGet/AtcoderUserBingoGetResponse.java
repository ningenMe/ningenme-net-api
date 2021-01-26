package ningenme.net.api.compro.application.controller.atcoderuserbingoGet;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.compro.application.controller.atcoderuserbingoGet.view.AtcoderUserHistoryView;
import ningenme.net.api.compro.domain.entity.AtcoderUserHistory;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AtcoderUserBingoGetResponse {
  private final List<AtcoderUserHistoryView> atcoderUserHistories;

  public static AtcoderUserBingoGetResponse of(List<AtcoderUserHistory> atcoderUserHistories) {
    return new AtcoderUserBingoGetResponse(
            atcoderUserHistories
                    .stream()
                    .map(atcoderUserHistory -> AtcoderUserHistoryView.of(atcoderUserHistory))
                    .collect(Collectors.toList())
    );
  }
}
