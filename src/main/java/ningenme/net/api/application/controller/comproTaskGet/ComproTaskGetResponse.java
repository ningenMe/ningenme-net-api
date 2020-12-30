package ningenme.net.api.application.controller.comproTaskGet;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.controller.comproTaskGet.view.ComproTaskView;
import ningenme.net.api.domain.entity.ComproTask;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ComproTaskGetResponse {
  private final ComproTaskView comproTask;
  public static ComproTaskGetResponse of(ComproTask comproTask) {
    return new ComproTaskGetResponse(ComproTaskView.of(comproTask));
  }
}
