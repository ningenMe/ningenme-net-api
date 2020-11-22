package ningenme.net.api.domain.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ContestName {
  private final String value;
  public static ContestName of(String contestName) {
    return new ContestName(contestName);
  }
}
