package ningenme.net.api.compro.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Country {
  private final String value;
  public static Country of(String country) {
    return new Country(country);
  }
}
