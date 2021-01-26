package ningenme.net.api.compro.application.controller.siteuserput;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.util.application.OkResponse;
import ningenme.net.api.domain.value.ComproSite;
import ningenme.net.api.compro.domain.service.SiteUserService;
import ningenme.net.api.domain.value.LogCode;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"compro-user"})
@RestController
@RequiredArgsConstructor
public class SiteUserPutController {

  private final SiteUserService siteUserService;

  @ApiOperation(value = "userの更新をkickするbatch用エンドポイント")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @PutMapping("/v1/compro/sites/{site_id}/users")
  public OkResponse put(
          @ApiParam(name = "site_id",value = "") @PathVariable(value = "site_id", required = true) String siteId)
  {
    siteUserService.put(ComproSite.of(siteId));
    return OkResponse.of(LogCode.API_INFO_202);
  }

}
