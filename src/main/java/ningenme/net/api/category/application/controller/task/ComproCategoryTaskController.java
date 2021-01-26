package ningenme.net.api.category.application.controller.task;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.application.controller.task.put.PutRequest;
import ningenme.net.api.category.application.controller.task.post.PostRequest;
import ningenme.net.api.category.application.controller.task.getCount.GetCountResponse;
import ningenme.net.api.category.application.controller.task.getList.GetListResponse;
import ningenme.net.api.category.application.controller.task.getOne.GetOneResponse;
import ningenme.net.api.util.application.OkResponse;
import ningenme.net.api.domain.entity.ComproCategoryTask;
import ningenme.net.api.domain.service.ComproCategoryTaskService;
import ningenme.net.api.domain.value.LogCode;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.Url;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Api(tags = {"compro-category"})
@RestController
@RequiredArgsConstructor
public class ComproCategoryTaskController {

    private final ComproCategoryTaskService comproCategoryTaskService;

    @ApiOperation(value = "ComproCategoryTask 複数参照API")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/v1/compro/category/tasks")
    public ResponseEntity<GetListResponse> getList(
            @ApiParam(value = "offset") @RequestParam(name = "offset", defaultValue = "0") Integer offset
    ) {
        List<ComproCategoryTask> comproCategoryTaskList = comproCategoryTaskService.getList(offset);
        return ResponseEntity.ok().body(
                GetListResponse.of(comproCategoryTaskList));
    }

    @ApiOperation(value = "ComproCategoryTask 単体参照API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/v1/compro/category/tasks/{taskId}")
    public ResponseEntity<GetOneResponse> getOne(
            @ApiParam(value = "taskId") @PathVariable(name = "taskId") String taskId
    ) {
        return ResponseEntity.ok().body(GetOneResponse.of(comproCategoryTaskService.getOne(taskId)));
    }

    @ApiOperation(value = "ComproCategoryTaskCount 参照API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/v1/compro/category/tasks/count")
    public ResponseEntity<GetCountResponse> getCount(
    ) {
        return ResponseEntity.ok().body(GetCountResponse.of(comproCategoryTaskService.getCount()));
    }

    @ApiOperation(value = "ComproCategoryTask 投稿API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping(path = "/v1/compro/category/tasks" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public OkResponse post (
            @Validated @RequestBody PostRequest request
            ) {
        ComproCategoryTask comproCategoryTask = ComproCategoryTask.of(
                UUID.randomUUID().toString(),
                Optional.ofNullable(request.getTaskName()).orElse("."),
                Url.of(request.getUrl()),
                TaskScore.of(Optional.ofNullable(request.getScore()).orElse(0)),
                TaskScore.of(Optional.ofNullable(request.getEstimation()).orElse(0)),
                request.getTopicIdList(),
                null
        );
        comproCategoryTaskService.post(comproCategoryTask);
        return OkResponse.of(LogCode.API_INFO_202);
    }

    @ApiOperation(value = "ComproCategoryTask 更新API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PutMapping(path = "/v1/compro/category/tasks/{taskId}" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public OkResponse put (
            @ApiParam(value = "taskId") @PathVariable(name = "taskId") String taskId,
            @Validated @RequestBody PutRequest request
    ) {
        ComproCategoryTask comproCategoryTask = ComproCategoryTask.of(
                taskId,
                request.getTaskName(),
                Url.of(request.getUrl()),
                TaskScore.of(request.getScore()),
                TaskScore.of(request.getEstimation()),
                request.getTopicIdList(),
                null
        );
        comproCategoryTaskService.put(comproCategoryTask);
        return OkResponse.of(LogCode.API_INFO_202);
    }

}