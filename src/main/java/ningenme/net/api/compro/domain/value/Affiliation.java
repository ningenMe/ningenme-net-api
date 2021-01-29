package ningenme.net.api.compro.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Affiliation {
  private final String value;

  public static Affiliation of(final String value) {
    return new Affiliation(value);
  }
}
