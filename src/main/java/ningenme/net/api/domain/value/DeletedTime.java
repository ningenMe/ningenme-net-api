package ningenme.net.api.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Getter
@RequiredArgsConstructor
public class DeletedTime {
  private final Timestamp value;
  public static DeletedTime of(Timestamp value) {
    return new DeletedTime(value);
  }
}
