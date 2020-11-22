package ningenme.net.api.application.controller.comproSiteUser;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.application.controller.util.OkResponse;
import ningenme.net.api.domain.entity.ComproSite;
import ningenme.net.api.domain.service.ComproSiteUserService;
import ningenme.net.api.domain.value.LogCode;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"compro-user"})
@RestController
@RequiredArgsConstructor
@Slf4j
public class ComproSiteUserController {

  private final ComproSiteUserService comproSiteUserService;

  @ApiOperation(value = "userのidリストを更新をkickするbatch用エンドポイント")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @PutMapping("/v1/compro/sites/{site}/users/id")
  public OkResponse putId(
          @ApiParam(name = "site",value = "") @PathVariable(value = "site", required = true) String site)
  {
    comproSiteUserService.putId(ComproSite.of(site));
    return OkResponse.of(LogCode.API_INFO_202);
  }

  @ApiOperation(value = "userを更新をkickするbatch用エンドポイント")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @PutMapping("/v1/compro/sites/{site}/users")
  public OkResponse put(
          @ApiParam(name = "site",value = "") @PathVariable(value = "site", required = true) String site)
  {
//    comproSiteUserService.put(ComproSite.of(site));
    return OkResponse.of(LogCode.API_INFO_202);
  }

}
