package ningenme.net.api.domain.value;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.regex.Pattern;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(description = "urlの値オブジェクト")
@Getter
public class Url {
  private static final Pattern REGEX_PATTERN = Pattern.compile("https?://[A-Za-z0-9!\\?/\\+\\-_~=;\\.,\\*&@#\\$%\\(\\)'\\[\\]]+");

  @JsonProperty("url")
  @ApiModelProperty(value = "url", example = "https://ningenme.net")
  @NonNull
  private final String value;

  public static Url of(@NonNull String url) throws NullPointerException,IllegalArgumentException {

    if(!REGEX_PATTERN.matcher(url).matches()) {
      throw new IllegalArgumentException("Illegal url" + url);
    }

    return new Url(url);
  }
}


