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
@ApiModel(description = "labelの値オブジェクト")
@Getter
public class Label {
  private static final Pattern REGEX_PATTERN = Pattern.compile("[a-z]+");
  @JsonProperty("label")
  @ApiModelProperty(value = "label", example = "search")
  @NonNull
  private final String value;

  public static Label of(@NonNull String label) throws NullPointerException,IllegalArgumentException {

    if(!REGEX_PATTERN.matcher(label).matches()) {
      throw new IllegalArgumentException("Illegal label" + label);
    }

    return new Label(label);
  }

}