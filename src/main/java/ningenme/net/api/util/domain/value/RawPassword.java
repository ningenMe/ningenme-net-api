package ningenme.net.api.util.domain.value;

import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(description = "パスワードの値オブジェクト")
public class RawPassword {

  private static final Pattern REGEX_PATTERN = Pattern.compile("[A-Za-z0-9]+");
  private static final Pattern REGEX_PATTERN_NO_UPPER = Pattern.compile("[a-z0-9]+");
  private static final Pattern REGEX_PATTERN_NO_LOWER = Pattern.compile("[A-Z0-9]+");
  private static final Pattern REGEX_PATTERN_NO_DIGIT = Pattern.compile("[A-Za-z]+");

  @JsonProperty("rawPassword")
  @ApiModelProperty(value = "rawPassword", example = "passwordPASSWORD12345")
  @NonNull
  private final String value;

  public static RawPassword of(@NonNull String rawPassword) throws NullPointerException,IllegalArgumentException {

    if(!REGEX_PATTERN.matcher(rawPassword).matches()) {
      throw new IllegalArgumentException("Illegal raw password " + rawPassword);
    }

    if(REGEX_PATTERN_NO_DIGIT.matcher(rawPassword).matches()
            || REGEX_PATTERN_NO_UPPER.matcher(rawPassword).matches()
            || REGEX_PATTERN_NO_LOWER.matcher(rawPassword).matches()) {
      throw new IllegalArgumentException("Illegal raw password " + rawPassword);
    }

    return new RawPassword(rawPassword);
  }

  @Override
  public String toString() {
    return value;
  }
}
