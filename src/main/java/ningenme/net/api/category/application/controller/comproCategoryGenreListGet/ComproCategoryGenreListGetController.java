package ningenme.net.api.category.application.controller.comproCategoryGenreListGet;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.service.ComproCategoryGenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"compro-category"})
@RestController
@RequiredArgsConstructor
public class ComproCategoryGenreListGetController {
  private final ComproCategoryGenreService comproCategoryGenreService;

  @ApiOperation(value = "ComproCategoryGenre 複数参照API")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/category/genres")
  public ResponseEntity<ComproCategoryGenreListGetResponse> get() {
    return ResponseEntity
            .ok()
            .body(
                    ComproCategoryGenreListGetResponse.of(
                            comproCategoryGenreService.get()
                    )
            );
  }

}