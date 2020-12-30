package ningenme.net.api.application.controller.comproSiteUserBingoGet;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.ComproSite;
import ningenme.net.api.domain.service.AtcoderUserService;
import ningenme.net.api.domain.service.ComproSiteUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Api(tags = {"compro-user"})
@RestController
@RequiredArgsConstructor
public class ComproSiteUserBingoGetController {

  private final ComproSiteUserService comproSiteUserService;
  private final AtcoderUserService atcoderUserService;

  @ApiOperation(value = "userの順位ビンゴを返すapi")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/sites/{site_id}/users/{user_id}/bingo")
  public ComproSiteUserBingoGetResponse bingoGet(
          @ApiParam(name = "site_id",value = "") @PathVariable(value = "site_id", required = true) String siteId,
          @ApiParam(name = "user_id",value = "") @PathVariable(value = "user_id", required = true) String userId
  )
  {
    ComproSite comproSite = ComproSite.of(siteId);
    return ComproSiteUserBingoGetResponse.of(new ArrayList<>());
  }

}
