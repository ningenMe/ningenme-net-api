package ningenme.net.api.util.application.controller.userpost;

import io.swagger.annotations.*;
import lombok.NonNull;
import ningenme.net.api.util.domain.service.NingenmeNetUserService;
import ningenme.net.api.util.application.OkResponse;
import ningenme.net.api.domain.value.Email;
import ningenme.net.api.domain.value.LogCode;
import ningenme.net.api.domain.value.RawPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@Api(tags = {"compro-category"})
@RestController
@RequestMapping("/v1/compro/category/users")
@RequiredArgsConstructor
public class UserPostController {

  @Autowired
  private final PasswordEncoder passwordEncoder;

  private final NingenmeNetUserService ningenmeNetUserService;

  @ApiOperation(value = "NingenmeNetUser 投稿API")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @PostMapping(value = "")
  public OkResponse insertComproCategoryUser(
          @ApiParam(required = true, value="e-mail") @RequestParam("email") @NonNull Email email,
          @ApiParam(required = true, value="パスワード") @RequestParam("rawPassword") @NonNull RawPassword rawPassword
  ) {
    //そもそも自分しかユーザーは作れないんだな
    //ningenmeNetUserService.insert(NingenmeNetUser.of(email,Password.of( rawPassword, passwordEncoder)));
    return OkResponse.of(LogCode.API_INFO_201);
  }
}
