package ningenme.net.api.application.controller.comproCategoryGenreListWithTopicGet;

import io.swagger.annotations.*;
import ningenme.net.api.domain.service.ComproCategoryGenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@Api(tags = {"compro-category"})
@RestController
@RequiredArgsConstructor
public class ComproCategoryGenreListWithTopicGetController {
  private final ComproCategoryGenreService comproCategoryGenreService;

  @ApiOperation(value = "ComproCategoryGenreWithTopic 複数参照API")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/category/genres/topics")
  public ResponseEntity<ComproCategoryGenreListWithTopicGetResponse> get() {
    return ResponseEntity
            .ok()
            .body(
                    ComproCategoryGenreListWithTopicGetResponse.of(
                            comproCategoryGenreService.getWithTopic()
                    )
            );
  }

}