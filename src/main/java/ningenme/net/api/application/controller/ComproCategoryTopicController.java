package ningenme.net.api.application.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.response.GetComproCategoryTopicListResponse;
import ningenme.net.api.application.response.GetComproCategoryTopicOneResponse;
import ningenme.net.api.domain.service.ComproCategoryTopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ComproCategoryTopicController {
    private final ComproCategoryTopicService comproCategoryTopicService;

    @ApiOperation(value = "ComproCategoryTopic 単体参照API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/v1/compro/category/topics/{topic_id}")
    public ResponseEntity<GetComproCategoryTopicOneResponse> get(
        @ApiParam("ラベル") @PathVariable("topic_id") Integer topicId
    ) {
        return ResponseEntity
                .ok()
                .body(
                        GetComproCategoryTopicOneResponse.of(
                                comproCategoryTopicService.get(topicId)
                        )
                );
    }

  @ApiOperation(value = "ComproCategoryTopicWithTask 単体参照API")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/category/topics/{topic_id}/tasks")
  public ResponseEntity<GetComproCategoryTopicOneResponse> getWithTask(
          @ApiParam("ラベル") @PathVariable("topic_id") Integer topicId
  ) {
    return ResponseEntity
            .ok()
            .body(
                    GetComproCategoryTopicOneResponse.of(
                            comproCategoryTopicService.getWithTask(topicId)
                    )
            );
  }

  @ApiOperation(value = "ComproCategoryTopic 複数参照API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/v1/compro/category/topics")
    public ResponseEntity<GetComproCategoryTopicListResponse> get() {
        return ResponseEntity
                .ok()
                .body(
                        GetComproCategoryTopicListResponse.of(
                                comproCategoryTopicService.get()
                        )
                );
    }

}