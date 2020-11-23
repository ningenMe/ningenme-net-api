package ningenme.net.api.application.controller.comproSiteUser.getAtcoderOne;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.AtcoderUser;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproComproSiteUserGetOneComproSiteUserResponseDto")
public class AtcoderUserResponseDto {
  private final String atcoderId;
//  private final Integer rate;
  private final String updatedTime;
  public static AtcoderUserResponseDto of(AtcoderUser atcoderUser) {
    return new AtcoderUserResponseDto(
            atcoderUser.getAtcoderId().getValue(),
//            atcoderUser.getCurrentRate().getValue(),
            atcoderUser.getUpdatedTime().toString()
    );
  }
}
