package ningenme.net.api.application.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.response.GetComproCategoryTaskListResponse;
import ningenme.net.api.domain.entity.ComproCategoryTask;
import ningenme.net.api.domain.service.ComproCategoryTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<GetComproCategoryTaskListResponse> get(
            @ApiParam(value = "offset") @RequestParam(name = "offset", defaultValue = "1") Integer offset
    ) {
        List<ComproCategoryTask> comproCategoryTaskList = comproCategoryTaskService.get(offset);
        return ResponseEntity.ok().body(
                GetComproCategoryTaskListResponse.of(comproCategoryTaskList,offset,offset + comproCategoryTaskList.size()));
    }

}