package ningenme.net.api.compro.application.controller.atcoderuserbingoGet;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.compro.domain.service.AtcoderUserService;
import ningenme.net.api.domain.value.AtcoderId;
import ningenme.net.api.domain.value.BingoType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"compro-user"})
@RestController
@RequiredArgsConstructor
public class AtcoderUserBingoGetController {

  private final AtcoderUserService atcoderUserService;

  @ApiOperation(value = "userの順位ビンゴを返すapi")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/sites/AtCoder/users/{atcoder_id}/bingo/{bingo_type}")
  public AtcoderUserBingoGetResponse bingoGet(
          @ApiParam(name = "atcoder_id",value = "") @PathVariable(value = "atcoder_id", required = true) String atcoderId,
          @ApiParam(name = "bingo_type",value = "") @PathVariable(value = "bingo_type", required = true) String bingoType
  )
  {
    return AtcoderUserBingoGetResponse.of(atcoderUserService.getBingo(AtcoderId.of(atcoderId),BingoType.of(bingoType)));
  }

}
