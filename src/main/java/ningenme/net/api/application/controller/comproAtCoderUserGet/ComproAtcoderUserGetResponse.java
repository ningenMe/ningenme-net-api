package ningenme.net.api.application.controller.comproAtCoderUserGet;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.controller.comproAtCoderUserGet.view.AtcoderUserView;
import ningenme.net.api.domain.entity.AtcoderUser;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproSiteUserGetOne")
public class ComproAtcoderUserGetResponse {
  private final AtcoderUserView atcoderUser;
  public static ComproAtcoderUserGetResponse of(AtcoderUser atcoderUser) {
    return new ComproAtcoderUserGetResponse(AtcoderUserView.of(atcoderUser));
  }
}
