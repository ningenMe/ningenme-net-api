package ningenme.net.api.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Getter
@RequiredArgsConstructor
public class EndTime {
  private final Timestamp value;
  public static EndTime of(Timestamp value) {
    return new EndTime(value);
  }
}
