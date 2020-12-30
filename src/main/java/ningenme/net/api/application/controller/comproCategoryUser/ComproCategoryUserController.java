package ningenme.net.api.application.controller.comproCategoryUser;

import io.swagger.annotations.*;
import lombok.NonNull;
import ningenme.net.api.domain.service.ComproCategoryUserService;
import ningenme.net.api.domain.value.Email;
import ningenme.net.api.domain.value.LogCode;
import ningenme.net.api.domain.value.RawPassword;
import ningenme.net.api.application.controller.util.OkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@Api(tags = {"compro-category"})
@RestController
@RequestMapping("/v1/compro/category/users")
@RequiredArgsConstructor
public class ComproCategoryUserController {

  @Autowired
  private final PasswordEncoder passwordEncoder;

  private final ComproCategoryUserService comproCategoryUserService;

  @ApiOperation(value = "ComproCategoryUser 投稿API")
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
    //comproCategoryUserService.insert(ComproCategoryUser.of(email,Password.of( rawPassword, passwordEncoder)));
    return OkResponse.of(LogCode.API_INFO_201);
  }
}
