package ningenme.net.api.compro.application.controller.atcoderUserGet;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.compro.application.controller.atcoderUserGet.view.AtcoderUserView;
import ningenme.net.api.compro.domain.entity.AtcoderUser;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproSiteUserGetOne")
public class AtcoderUserGetResponse {
  private final AtcoderUserView atcoderUser;
  public static AtcoderUserGetResponse of(AtcoderUser atcoderUser) {
    return new AtcoderUserGetResponse(AtcoderUserView.of(atcoderUser));
  }
}
