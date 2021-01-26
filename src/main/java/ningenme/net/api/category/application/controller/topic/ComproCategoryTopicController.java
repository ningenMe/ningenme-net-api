package ningenme.net.api.category.application.controller.topic;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.application.controller.topic.getList.GetListResponse;
import ningenme.net.api.category.application.controller.topic.getOne.GetOneResponse;
import ningenme.net.api.category.application.controller.topic.getOneWithTask.GetOneWithTaskResponse;
import ningenme.net.api.category.domain.service.TopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"compro-category"})
@RestController
@RequiredArgsConstructor
public class ComproCategoryTopicController {
    private final TopicService topicService;

    @ApiOperation(value = "Topic 単体参照API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/v1/compro/category/topics/{topic_id}")
    public ResponseEntity<GetOneResponse> get(
        @ApiParam("ラベル") @PathVariable("topic_id") String topicId
    ) {
        return ResponseEntity
                .ok()
                .body(
                        GetOneResponse.of(
                                topicService.get(topicId)
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
  public ResponseEntity<GetOneWithTaskResponse> getWithTask(
          @ApiParam("ラベル") @PathVariable("topic_id") String topicId
  ) {
    return ResponseEntity
            .ok()
            .body(
                    GetOneWithTaskResponse.of(
                            topicService.getWithTask(topicId)
                    )
            );
  }

  @ApiOperation(value = "Topic 複数参照API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/v1/compro/category/topics")
    public ResponseEntity<GetListResponse> get() {
        return ResponseEntity
                .ok()
                .body(
                        GetListResponse.of(
                                topicService.get()
                        )
                );
    }

}