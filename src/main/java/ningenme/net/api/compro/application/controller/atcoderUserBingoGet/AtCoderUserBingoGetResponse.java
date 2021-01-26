package ningenme.net.api.compro.application.controller.atcoderUserBingoGet;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.compro.application.controller.atcoderUserBingoGet.view.AtcoderUserHistoryView;
import ningenme.net.api.compro.domain.entity.AtcoderUserHistory;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AtCoderUserBingoGetResponse {
  private final List<AtcoderUserHistoryView> atcoderUserHistories;

  public static AtCoderUserBingoGetResponse of(List<AtcoderUserHistory> atcoderUserHistories) {
    return new AtCoderUserBingoGetResponse(
            atcoderUserHistories
                    .stream()
                    .map(atcoderUserHistory -> AtcoderUserHistoryView.of(atcoderUserHistory))
                    .collect(Collectors.toList())
    );
  }
}
