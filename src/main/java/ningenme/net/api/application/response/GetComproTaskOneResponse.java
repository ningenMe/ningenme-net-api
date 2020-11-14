package ningenme.net.api.application.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;
import ningenme.net.api.domain.entity.ComproTask;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GetComproTaskOneResponse {
  private final ComproTask comproTask;
  public static GetComproTaskOneResponse of(ComproTask comproTask) {
    return new GetComproTaskOneResponse(comproTask);
  }
}
