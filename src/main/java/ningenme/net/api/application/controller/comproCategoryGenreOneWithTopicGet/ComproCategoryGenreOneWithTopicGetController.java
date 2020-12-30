package ningenme.net.api.application.controller.comproCategoryGenreOneWithTopicGet;

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
public class ComproCategoryGenreOneWithTopicGetController {
  private final ComproCategoryGenreService comproCategoryGenreService;

  @ApiOperation(value = "ComproCategoryGenreWithTopic 単体参照API")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/category/genres/{label}/topics")
  public ResponseEntity<ComproCategoryGenreOneWithTopicGetResponse> get(
          @ApiParam("ラベル") @PathVariable String label
  ) {
    return ResponseEntity
            .ok()
            .body(
                    ComproCategoryGenreOneWithTopicGetResponse.of(
                            comproCategoryGenreService.getWithTopics(Label.of(label))
                    )
            );
  }
}