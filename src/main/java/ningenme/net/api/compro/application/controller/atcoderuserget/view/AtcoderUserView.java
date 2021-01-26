package ningenme.net.api.compro.application.controller.atcoderuserget.view;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.compro.domain.entity.AtcoderUser;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproComproSiteUserGetOneComproSiteUserResponseDto")
public class AtcoderUserView {
  private final String atcoderId;
//  private final Integer rate;
  private final String updatedTime;
  public static AtcoderUserView of(AtcoderUser atcoderUser) {
    return new AtcoderUserView(
            atcoderUser.getAtcoderId().getValue(),
//            atcoderUser.getCurrentRate().getValue(),
            atcoderUser.getUpdatedTime().getValue().toString()
    );
  }
}
