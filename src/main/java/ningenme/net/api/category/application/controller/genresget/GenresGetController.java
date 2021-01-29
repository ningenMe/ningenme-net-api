package ningenme.net.api.category.application.controller.genresget;

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
public class GenresGetController {
  private final GenreService genreService;

  @ApiOperation(value = "Genre一覧参照API")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/category/genres")
  public GenresGetResponse get() {
    return GenresGetResponse.of(genreService.get());
  }

}