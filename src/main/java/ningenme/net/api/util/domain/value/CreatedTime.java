package ningenme.net.api.util.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Getter
@RequiredArgsConstructor
public class CreatedTime {
  private final Timestamp value;
  public static CreatedTime of(Timestamp value) {
    return new CreatedTime(value);
  }
}
