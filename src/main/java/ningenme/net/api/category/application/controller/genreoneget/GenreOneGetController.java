package ningenme.net.api.category.application.controller.genreoneget;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.service.GenreService;
import ningenme.net.api.category.domain.value.Label;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"compro-category"})
@RestController
@RequiredArgsConstructor
public class GenreOneGetController {
  private final GenreService genreService;

  @ApiOperation(value = "Genre 単体参照API")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/category/genres/{label}")
  public GenreOneGetResponse get(
          @ApiParam("ラベル") @PathVariable String label
  ) {
    return GenreOneGetResponse.of(genreService.get(Label.of(label)));
  }
}