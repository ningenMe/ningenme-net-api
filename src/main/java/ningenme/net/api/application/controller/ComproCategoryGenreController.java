package ningenme.net.api.application.controller;

import io.swagger.annotations.*;
import ningenme.net.api.application.response.GetComproCategoryGenreListResponse;
import ningenme.net.api.application.response.GetComproCategoryGenreOneResponse;
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
    public ResponseEntity<GetComproCategoryGenreOneResponse> get(
        @ApiParam("ラベル") @PathVariable String label
    ) {
        return ResponseEntity
                .ok()
                .body(
                        GetComproCategoryGenreOneResponse.of(
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
  public ResponseEntity<GetComproCategoryGenreOneResponse> getWithTopics(
          @ApiParam("ラベル") @PathVariable String label
  ) {
    return ResponseEntity
            .ok()
            .body(
                    GetComproCategoryGenreOneResponse.of(
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
    public ResponseEntity<GetComproCategoryGenreListResponse> get() {
        return ResponseEntity
                .ok()
                .body(
                        GetComproCategoryGenreListResponse.of(
                                comproCategoryGenreService.get()
                        )
                );
    }

}