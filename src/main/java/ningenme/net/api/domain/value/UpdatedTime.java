package ningenme.net.api.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Getter
@RequiredArgsConstructor
public class UpdatedTime {
  private final Timestamp value;
  public static UpdatedTime of(Timestamp value) {
    return new UpdatedTime(value);
  }
}
