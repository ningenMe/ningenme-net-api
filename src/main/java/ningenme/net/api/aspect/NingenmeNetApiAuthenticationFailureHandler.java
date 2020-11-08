package ningenme.net.api.aspect;

import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.value.LogCode;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class NingenmeNetApiAuthenticationFailureHandler implements AuthenticationFailureHandler {
  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
    if(!response.isCommitted()) {
      log.error("code={},message={}", LogCode.API_INFO_405.getCode(),LogCode.API_INFO_405.getMessage());
      response.sendError(HttpStatus.FORBIDDEN.value(),"hoge");
    }
  }
}
