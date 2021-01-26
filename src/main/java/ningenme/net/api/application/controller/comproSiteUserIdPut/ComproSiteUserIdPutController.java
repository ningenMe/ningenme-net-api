package ningenme.net.api.application.controller.comproSiteUserIdPut;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.controller.util.OkResponse;
import ningenme.net.api.compro.domain.service.SiteUserService;
import ningenme.net.api.domain.value.ComproSite;
import ningenme.net.api.domain.value.LogCode;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"compro-user"})
@RestController
@RequiredArgsConstructor
public class ComproSiteUserIdPutController {

  private final SiteUserService siteUserService;

  @ApiOperation(value = "userのidリスト更新をkickするbatch用エンドポイント")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @PutMapping("/v1/compro/sites/{site_id}/users/id")
  public OkResponse putId(
          @ApiParam(name = "site_id",value = "") @PathVariable(value = "site_id", required = true) String siteId)
  {
    siteUserService.putId(ComproSite.of(siteId));
    return OkResponse.of(LogCode.API_INFO_202);
  }
}
