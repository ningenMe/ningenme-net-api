package ningenme.net.api.application.controller.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.LogCode;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class OkResponse {

  @JsonProperty("httpStatus")
  private final Integer httpStatus;
  private final String code;
  private final String message;

  public static OkResponse of(LogCode logCode) {
    return new OkResponse(HttpStatus.OK.value(), logCode.getCode(), logCode.getMessage());
  }
}
