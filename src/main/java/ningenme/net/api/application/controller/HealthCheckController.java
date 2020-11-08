package ningenme.net.api.application.controller;

import ningenme.net.api.application.response.OkResponse;
import ningenme.net.api.domain.value.LogCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
public class HealthCheckController {

  @GetMapping("/health")
  OkResponse getHealthCheck() {
    return OkResponse.of(LogCode.API_INFO_202);
  }
}
