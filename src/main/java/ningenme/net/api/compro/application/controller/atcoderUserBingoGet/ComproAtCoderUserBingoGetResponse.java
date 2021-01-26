package ningenme.net.api.compro.application.controller.atcoderUserBingoGet;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.compro.application.controller.atcoderUserBingoGet.view.AtcoderUserHistoryView;
import ningenme.net.api.domain.entity.AtcoderUserHistory;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ComproAtCoderUserBingoGetResponse {
  private final List<AtcoderUserHistoryView> atcoderUserHistories;

  public static ComproAtCoderUserBingoGetResponse of(List<AtcoderUserHistory> atcoderUserHistories) {
    return new ComproAtCoderUserBingoGetResponse(
            atcoderUserHistories
                    .stream()
                    .map(atcoderUserHistory -> AtcoderUserHistoryView.of(atcoderUserHistory))
                    .collect(Collectors.toList())
    );
  }
}
