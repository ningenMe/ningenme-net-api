package ningenme.net.api.category.application.controller.genreonewithtopicsget;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.service.GenreService;
import ningenme.net.api.category.domain.value.Label;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"category-genre"})
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
  @GetMapping("/v1/category/genres/{label}/topics")
  public GenreOneWithTopicGetResponse get(
          @ApiParam("ラベル") @PathVariable("label") String label
  ) {
    return GenreOneWithTopicGetResponse.of(genreService.getWithTopics(Label.of(label)));
  }
}