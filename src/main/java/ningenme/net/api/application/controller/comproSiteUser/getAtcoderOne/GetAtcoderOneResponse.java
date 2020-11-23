package ningenme.net.api.application.controller.comproSiteUser.getAtcoderOne;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.AtcoderUser;
import ningenme.net.api.domain.entity.ComproSite;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproSiteUserGetOne")
public class GetAtcoderOneResponse {
  private final AtcoderUserResponseDto atcoderUser;
  public static GetAtcoderOneResponse of(AtcoderUser atcoderUser) {
    return new GetAtcoderOneResponse(AtcoderUserResponseDto.of(atcoderUser));
  }
}
