package ningenme.net.api.domain.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Rank {
  private final Integer value;
  public static Rank of(Integer rank) {
    return new Rank(rank);
  }
}
