package ningenme.net.api.compro.domain.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Performance {
  private final Integer value;
  public static Performance of(Integer performance) {
    return new Performance(performance);
  }
}
