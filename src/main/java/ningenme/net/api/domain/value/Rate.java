package ningenme.net.api.domain.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Rate {
  private final Integer value;
  public static Rate of(Integer rate) {
    return new Rate(rate);
  }
}
