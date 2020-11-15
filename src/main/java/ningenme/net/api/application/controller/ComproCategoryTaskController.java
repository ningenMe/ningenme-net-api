package ningenme.net.api.application.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.application.request.PostComproCategoryTaskRequest;
import ningenme.net.api.application.response.GetComproCategoryTaskCountResponse;
import ningenme.net.api.application.response.GetComproCategoryTaskListResponse;
import ningenme.net.api.application.response.GetComproCategoryTaskOneResponse;
import ningenme.net.api.application.response.OkResponse;
import ningenme.net.api.domain.entity.ComproCategoryTask;
import ningenme.net.api.domain.service.ComproCategoryTaskService;
import ningenme.net.api.domain.value.LogCode;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.TaskUniqueId;
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
@Slf4j
public class ComproCategoryTaskController {

    private final ComproCategoryTaskService comproCategoryTaskService;

    @ApiOperation(value = "ComproCategoryTask 複数参照API")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/v1/compro/category/tasks")
    public ResponseEntity<GetComproCategoryTaskListResponse> getTaskList(
            @ApiParam(value = "offset") @RequestParam(name = "offset", defaultValue = "0") Integer offset
    ) {
        List<ComproCategoryTask> comproCategoryTaskList = comproCategoryTaskService.getList(offset);
        return ResponseEntity.ok().body(
                GetComproCategoryTaskListResponse.of(comproCategoryTaskList,offset,offset + comproCategoryTaskList.size()));
    }

    @ApiOperation(value = "ComproCategoryTask 単体参照API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/v1/compro/category/tasks/{taskId}")
    public ResponseEntity<GetComproCategoryTaskOneResponse> getTaskOne(
            @ApiParam(value = "taskId") @PathVariable(name = "taskId") String taskId
    ) {
        return ResponseEntity.ok().body(GetComproCategoryTaskOneResponse.of(comproCategoryTaskService.getOne(taskId)));
    }

    @ApiOperation(value = "ComproCategoryTaskCount 参照API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/v1/compro/category/tasks/count")
    public ResponseEntity<GetComproCategoryTaskCountResponse> getTaskCount(
    ) {
        return ResponseEntity.ok().body(GetComproCategoryTaskCountResponse.of(comproCategoryTaskService.getCount()));
    }

    @ApiOperation(value = "ComproCategoryTask 投稿API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping(path = "/v1/compro/category/tasks" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public OkResponse post (
            @Validated @RequestBody PostComproCategoryTaskRequest request
            ) {
        ComproCategoryTask comproCategoryTask = ComproCategoryTask.of(
                UUID.randomUUID().toString(),
                Optional.ofNullable(request.getTaskName()).orElse(""),
                Url.of(request.getUrl()),
                TaskScore.of(Optional.ofNullable(request.getScore()).orElse(0)),
                TaskScore.of(Optional.ofNullable(request.getEstimation()).orElse(0)),
                request.getTopicIdList(),
                null
        );
        comproCategoryTaskService.post(comproCategoryTask);
        return OkResponse.of(LogCode.API_INFO_202);
    }
}