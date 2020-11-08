package ningenme.net.api.aspect;

import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.exception.InsertComproCategoryUserException;
import ningenme.net.api.domain.value.LogCode;
import ningenme.net.api.application.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice
public class NingenmeNetApiControllerAdvice {

  private ResponseEntity<ErrorResponse> commonHandle(HttpStatus httpStatus, LogCode logCode, Exception ex) {
    log.error("code={}, message={}",logCode.getCode(),logCode.getMessage(),ex);
    return new ResponseEntity<>(ErrorResponse.of(httpStatus,logCode,ex), httpStatus);
  }
  private ResponseEntity<ErrorResponse> commonHandle(HttpStatus httpStatus, LogCode logCode) {
    log.error("code={}, message={}",logCode.getCode(),logCode.getMessage());
    return new ResponseEntity<>(ErrorResponse.of(httpStatus,logCode), httpStatus);
  }

  /**
   * 拾えていないエラー全般
   * @param ex exception
   * @return エラーレスポンス
   */
  @ExceptionHandler
  public ResponseEntity<ErrorResponse> exceptionHandle(Exception ex) {
    return commonHandle(HttpStatus.INTERNAL_SERVER_ERROR,LogCode.API_INFO_501,ex);
  }

  /**
   * comproCategoryのinsert時のエラー全般
   * @param ex exception
   * @return エラーレスポンス
   */
  @ExceptionHandler({InsertComproCategoryUserException.class})
  public ResponseEntity<ErrorResponse> insertComproCategoryUserExceptionHandle(Exception ex) {
    return commonHandle(HttpStatus.INTERNAL_SERVER_ERROR,LogCode.API_INFO_502,ex);
  }

  /**
   * 引数おかしいエラー
   * @param ex exception
   * @return エラーレスポンス
   */
  @ExceptionHandler({IllegalArgumentException.class})
  public ResponseEntity<ErrorResponse> IllegalArgumentExceptionHandle(Exception ex) {
    return commonHandle(HttpStatus.BAD_REQUEST,LogCode.API_INFO_401);
  }

  /**
   * 引数おかしいエラー
   * @param ex exception
   * @return エラーレスポンス
   */
  @ExceptionHandler({MethodArgumentTypeMismatchException.class})
  public ResponseEntity<ErrorResponse> MethodArgumentTypeMismatchExceptionHandle(Exception ex) {
    return commonHandle(HttpStatus.BAD_REQUEST,LogCode.API_INFO_401);
  }

  /**
   * 存在しないURI
   * @param ex exception
   * @return エラーレスポンス
   */
  @ExceptionHandler({NoHandlerFoundException.class})
  public ResponseEntity<ErrorResponse> NoHandlerFoundExceptionHandle(Exception ex) {
    return commonHandle(HttpStatus.NOT_FOUND,LogCode.API_INFO_402);
  }

  /**
   * メソッドがおかしい
   * @param ex exception
   * @return エラーレスポンス
   */
  @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
  public ResponseEntity<ErrorResponse> HttpRequestMethodNotSupportedExceptionHandle(Exception ex) {
    return commonHandle(HttpStatus.BAD_REQUEST,LogCode.API_INFO_403);
  }

  /**
   * メソッドがおかしい
   * @param ex exception
   * @return エラーレスポンス
   */
  @ExceptionHandler({MissingServletRequestParameterException.class})
  public ResponseEntity<ErrorResponse> MissingServletRequestParameterExceptionHandle(Exception ex) {
    return commonHandle(HttpStatus.BAD_REQUEST,LogCode.API_INFO_404);
  }

}
