package ningenme.net.api.category.application.controller.genrelistget;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.service.ComproCategoryGenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"compro-category"})
@RestController
@RequiredArgsConstructor
public class GenreListGetController {
  private final ComproCategoryGenreService comproCategoryGenreService;

  @ApiOperation(value = "Genre 複数参照API")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/category/genres")
  public GenreListGetResponse get() {
    return GenreListGetResponse.of(comproCategoryGenreService.get());
  }

}