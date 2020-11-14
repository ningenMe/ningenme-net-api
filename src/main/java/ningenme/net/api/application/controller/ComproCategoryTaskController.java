package ningenme.net.api.application.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.application.response.GetComproCategoryTaskCountResponse;
import ningenme.net.api.application.response.GetComproCategoryTaskListResponse;
import ningenme.net.api.application.response.GetComproCategoryTaskOneResponse;
import ningenme.net.api.application.response.OkResponse;
import ningenme.net.api.domain.entity.ComproCategoryTask;
import ningenme.net.api.domain.service.ComproCategoryTaskService;
import ningenme.net.api.domain.value.LogCode;
import ningenme.net.api.domain.value.Url;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            @ApiParam(value = "offset") @RequestParam(name = "offset", defaultValue = "1") Integer offset
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
    @GetMapping("/v1/compro/category/tasks/{task_id}")
    public ResponseEntity<GetComproCategoryTaskOneResponse> getTaskOne(
            @ApiParam(value = "taskId") @PathVariable(name = "task_id") Integer taskId
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
    @PostMapping("/v1/compro/category/tasks")
    public OkResponse postTask (
            @ApiParam("url") @RequestParam(value = "url", required = true) Url url
            ) {
        log.info("url={}",url.getValue());
        return OkResponse.of(LogCode.API_INFO_202);
    }

}