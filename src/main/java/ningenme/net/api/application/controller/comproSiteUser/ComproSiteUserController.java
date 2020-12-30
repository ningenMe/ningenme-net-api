package ningenme.net.api.application.controller.comproSiteUser;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.controller.comproSiteUser.getAtcoderOne.GetAtcoderOneResponse;
import ningenme.net.api.application.controller.util.OkResponse;
import ningenme.net.api.domain.value.ComproSite;
import ningenme.net.api.domain.service.AtcoderUserService;
import ningenme.net.api.domain.service.ComproSiteUserService;
import ningenme.net.api.domain.value.AtcoderId;
import ningenme.net.api.domain.value.LogCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"compro-user"})
@RestController
@RequiredArgsConstructor
public class ComproSiteUserController {

  private final ComproSiteUserService comproSiteUserService;
  private final AtcoderUserService atcoderUserService;

  @ApiOperation(value = "userのidリスト更新をkickするbatch用エンドポイント")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @PutMapping("/v1/compro/sites/{site_id}/users/id")
  public OkResponse putId(
          @ApiParam(name = "site_id",value = "") @PathVariable(value = "site_id", required = true) String siteId)
  {
    comproSiteUserService.putId(ComproSite.of(siteId));
    return OkResponse.of(LogCode.API_INFO_202);
  }

  @ApiOperation(value = "userの更新をkickするbatch用エンドポイント")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @PutMapping("/v1/compro/sites/{site_id}/users")
  public OkResponse put(
          @ApiParam(name = "site_id",value = "") @PathVariable(value = "site_id", required = true) String siteId)
  {
    comproSiteUserService.put(ComproSite.of(siteId));
    return OkResponse.of(LogCode.API_INFO_202);
  }

  @ApiOperation(value = "atcoder userを返すapi")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/sites/AtCoder/users/{atcoder_id}")
  public GetAtcoderOneResponse getAtcoderOne(
          @ApiParam(name = "atcoder_id",value = "") @PathVariable(value = "atcoder_id", required = true) String atcoderId
  )
  {
    return GetAtcoderOneResponse.of(atcoderUserService.getOne(AtcoderId.of(atcoderId)));
  }

}
