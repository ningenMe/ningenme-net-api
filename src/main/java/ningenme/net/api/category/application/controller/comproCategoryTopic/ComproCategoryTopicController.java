package ningenme.net.api.category.application.controller.comproCategoryTopic;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.application.controller.comproCategoryTopic.getList.GetListResponse;
import ningenme.net.api.category.application.controller.comproCategoryTopic.getOne.GetOneResponse;
import ningenme.net.api.category.application.controller.comproCategoryTopic.getOneWithTask.GetOneWithTaskResponse;
import ningenme.net.api.domain.service.ComproCategoryTopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"compro-category"})
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
    public ResponseEntity<GetOneResponse> get(
        @ApiParam("ラベル") @PathVariable("topic_id") String topicId
    ) {
        return ResponseEntity
                .ok()
                .body(
                        GetOneResponse.of(
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
  public ResponseEntity<GetOneWithTaskResponse> getWithTask(
          @ApiParam("ラベル") @PathVariable("topic_id") String topicId
  ) {
    return ResponseEntity
            .ok()
            .body(
                    GetOneWithTaskResponse.of(
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
    public ResponseEntity<GetListResponse> get() {
        return ResponseEntity
                .ok()
                .body(
                        GetListResponse.of(
                                comproCategoryTopicService.get()
                        )
                );
    }

}