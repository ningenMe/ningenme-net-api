package ningenme.net.api.application.controller.util;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.LogCode;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {
  private final Integer httpStatus;
  private final String code;
  private final String message;

  public static ErrorResponse of(HttpStatus httpStatus, LogCode logCode) {
    return new ErrorResponse(httpStatus.value(), logCode.getCode(), logCode.getMessage());
  }

  public static ErrorResponse of(HttpStatus httpStatus, LogCode logCode, Exception ex) {
    return new ErrorResponse(httpStatus.value(), logCode.getCode(), logCode.getMessage() + ": " + ex.toString());
  }
}
