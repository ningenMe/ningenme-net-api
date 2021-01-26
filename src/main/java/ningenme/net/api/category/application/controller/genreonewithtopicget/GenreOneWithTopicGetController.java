package ningenme.net.api.category.application.controller.genreonewithtopicget;

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
public class GenreOneWithTopicGetController {
  private final GenreService genreService;

  @ApiOperation(value = "ComproCategoryGenreWithTopic 単体参照API")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/category/genres/{label}/topics")
  public GenreOneWithTopicGetResponse get(
          @ApiParam("ラベル") @PathVariable String label
  ) {
    return GenreOneWithTopicGetResponse.of(genreService.getWithTopics(Label.of(label)));
  }
}