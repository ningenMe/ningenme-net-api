package ningenme.net.api.domain.value;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(description = "atcoder id")
@Getter
public class AtcoderId {
  private final String value;
  public static AtcoderId of(String atcoderId) {
    return new AtcoderId(atcoderId);
  }
}
