package ningenme.net.api.application.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.application.response.GetComproTaskOneResponse;
import ningenme.net.api.domain.service.ComproTaskService;
import ningenme.net.api.domain.value.Url;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ComproTaskController {

  private final ComproTaskService comproTaskService;

  @ApiOperation(value = "コンテストの問題のurlを渡すと情報をjsonで返してくれるAPI")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping("/v1/compro/tasks")
  public ResponseEntity<GetComproTaskOneResponse> getTask(
          @ApiParam("url") @RequestParam(value = "url", required = true) Url url
  ) {
    log.info("url={}",url.getValue());
    return ResponseEntity.ok().body(GetComproTaskOneResponse.of(
            comproTaskService.get(url)
    ));
  }

}