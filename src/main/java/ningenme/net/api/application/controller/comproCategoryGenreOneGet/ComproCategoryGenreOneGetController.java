package ningenme.net.api.application.controller.comproCategoryGenreOneGet;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.service.ComproCategoryGenreService;
import ningenme.net.api.domain.value.Label;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"compro-category"})
@RestController
@RequiredArgsConstructor
public class ComproCategoryGenreOneGetController {
  private final ComproCategoryGenreService comproCategoryGenreService;

  @ApiOperation(value = "ComproCategoryGenre 単体参照API")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/category/genres/{label}")
  public ResponseEntity<ComproCategoryGenreOneGetResponse> get(
          @ApiParam("ラベル") @PathVariable String label
  ) {
    return ResponseEntity
            .ok()
            .body(
                    ComproCategoryGenreOneGetResponse.of(
                            comproCategoryGenreService.get(Label.of(label))
                    )
            );
  }
}