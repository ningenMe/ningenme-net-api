package ningenme.net.api.application.controller.comproAtCoderUserGet;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.service.AtcoderUserService;
import ningenme.net.api.domain.value.AtcoderId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"compro-user"})
@RestController
@RequiredArgsConstructor
public class ComproAtCoderUserGetController {

  private final AtcoderUserService atcoderUserService;

  @ApiOperation(value = "atcoder userを返すapi")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/sites/AtCoder/users/{atcoder_id}")
  public ComproAtcoderUserGetResponse get(
          @ApiParam(name = "atcoder_id",value = "") @PathVariable(value = "atcoder_id", required = true) String atcoderId
  )
  {
    return ComproAtcoderUserGetResponse.of(atcoderUserService.getOne(AtcoderId.of(atcoderId)));
  }

}
