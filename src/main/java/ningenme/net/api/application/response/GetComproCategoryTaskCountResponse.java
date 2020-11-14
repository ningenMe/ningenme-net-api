package ningenme.net.api.application.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTask;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GetComproCategoryTaskCountResponse {
  private final Integer count;
  public static GetComproCategoryTaskCountResponse of(@NonNull Integer count) {
    return new GetComproCategoryTaskCountResponse(count);
  }
}
