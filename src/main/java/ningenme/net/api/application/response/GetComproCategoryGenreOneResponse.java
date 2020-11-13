package ningenme.net.api.application.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GetComproCategoryGenreOneResponse {
  private final ComproCategoryGenre comproCategoryGenre;
  public static GetComproCategoryGenreOneResponse of(@NonNull ComproCategoryGenre comproCategoryGenre) {
    return new GetComproCategoryGenreOneResponse(comproCategoryGenre);
  }
}
