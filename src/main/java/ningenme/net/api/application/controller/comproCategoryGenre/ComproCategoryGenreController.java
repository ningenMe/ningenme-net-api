package ningenme.net.api.application.controller.comproCategoryGenre;

import io.swagger.annotations.*;
import ningenme.net.api.application.controller.comproCategoryGenre.getList.GetListResponse;
import ningenme.net.api.application.controller.comproCategoryGenre.getListWithTopic.getList.GetListWithTopicResponse;
import ningenme.net.api.application.controller.comproCategoryGenre.getOne.GetOneResponse;
import ningenme.net.api.application.controller.comproCategoryGenre.getOneWithTopic.GetOneWithTopicResponse;
import ningenme.net.api.domain.service.ComproCategoryGenreService;
import ningenme.net.api.domain.value.Label;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@Api(tags = {"compro-category"})
@RestController
@RequiredArgsConstructor
public class ComproCategoryGenreController {
  private final ComproCategoryGenreService comproCategoryGenreService;

  @ApiOperation(value = "ComproCategoryGenre 単体参照API")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/category/genres/{label}")
  public ResponseEntity<GetOneResponse> getOne(
          @ApiParam("ラベル") @PathVariable String label
  ) {
    return ResponseEntity
            .ok()
            .body(
                    GetOneResponse.of(
                            comproCategoryGenreService.get(Label.of(label))
                    )
            );
  }

  @ApiOperation(value = "ComproCategoryGenreWithTopic 単体参照API")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/category/genres/{label}/topics")
  public ResponseEntity<GetOneWithTopicResponse> getOneWithTopic(
          @ApiParam("ラベル") @PathVariable String label
  ) {
    return ResponseEntity
            .ok()
            .body(
                    GetOneWithTopicResponse.of(
                            comproCategoryGenreService.getWithTopics(Label.of(label))
                    )
            );
  }

  @ApiOperation(value = "ComproCategoryGenre 複数参照API")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/category/genres")
  public ResponseEntity<GetListResponse> getList() {
    return ResponseEntity
            .ok()
            .body(
                    GetListResponse.of(
                            comproCategoryGenreService.get()
                    )
            );
  }

  @ApiOperation(value = "ComproCategoryGenreWithTopic 複数参照API")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/category/genres/topics")
  public ResponseEntity<GetListWithTopicResponse> getListWithTopic() {
    return ResponseEntity
            .ok()
            .body(
                    GetListWithTopicResponse.of(
                            comproCategoryGenreService.getWithTopic()
                    )
            );
  }

}