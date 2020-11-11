package ningenme.net.api.domain.value;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(description = "パスワードの値オブジェクト")
public class Password {

  @JsonProperty("password")
  @ApiModelProperty(value = "password")
  @NonNull
  private final String value;

  public static Password of(@NonNull RawPassword rawPassword, @NonNull PasswordEncoder passwordEncoder) throws NullPointerException {
    return new Password( passwordEncoder.encode(rawPassword.toString()) );
  }

  /**
   * DTOから戻すときはこっちのofメソッドを使う。
   * @param encodedPassword
   * @return
   * @throws NullPointerException
   */
  public static Password of(@NonNull String encodedPassword) throws NullPointerException {
    return new Password( encodedPassword );
  }

  @Override
  public String toString() {
    return value;
  }
}
