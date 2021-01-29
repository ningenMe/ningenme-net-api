package ningenme.net.api.compro.application.controller.taskget;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.compro.domain.service.TaskService;
import ningenme.net.api.util.domain.value.Url;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"compro-task"})
@RestController
@RequiredArgsConstructor
@Slf4j
public class TaskGetController {

  private final TaskService taskService;

  @ApiOperation(value = "問題のurlを渡すと情報を返してくれるAPI")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/tasks")
  public ResponseEntity<TaskGetResponse> get(
          @ApiParam(name = "url",value = "AtCoder,Codeforces,yukicoder,旧aojに対応") @RequestParam(value = "url", required = true) Url url
  ) {
    log.info("url={}",url.getValue());
    return ResponseEntity.ok().body(TaskGetResponse.of(
            taskService.get(url)
    ));
  }

}
