package ningenme.net.api.compro.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Getter
@RequiredArgsConstructor
public class StartTime {
  private final Timestamp value;
  public static StartTime of(Timestamp value) {
    return new StartTime(value);
  }
}
