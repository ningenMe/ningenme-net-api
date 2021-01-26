package ningenme.net.api.category.application.controller.genrelistwithtopicget;

import io.swagger.annotations.*;
import ningenme.net.api.category.domain.service.GenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@Api(tags = {"compro-category"})
@RestController
@RequiredArgsConstructor
public class GenreListWithTopicGetController {
  private final GenreService genreService;

  @ApiOperation(value = "ComproCategoryGenreWithTopic 複数参照API")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/category/genres/topics")
  public GenreListWithTopicGetResponse get() {
    return GenreListWithTopicGetResponse.of(genreService.getWithTopic());
  }
}