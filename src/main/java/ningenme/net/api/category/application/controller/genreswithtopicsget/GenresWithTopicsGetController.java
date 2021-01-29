package ningenme.net.api.category.application.controller.genreswithtopicsget;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.service.GenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = {"category-genre"})
@RestController
@RequiredArgsConstructor
public class GenresWithTopicsGetController {
  private final GenreService genreService;

  @ApiOperation(value = "Genre一覧Topicつき参照API")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/category/genres/topics")
  public GenresWithTopicsGetResponse get() {
    return GenresWithTopicsGetResponse.of(genreService.getWithTopic());
  }
}