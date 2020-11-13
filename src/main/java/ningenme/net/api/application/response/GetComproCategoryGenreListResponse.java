package ningenme.net.api.application.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GetComproCategoryGenreListResponse {
  private final List<ComproCategoryGenre> comproCategoryGenreList;
  public static GetComproCategoryGenreListResponse of(@NonNull List<ComproCategoryGenre> comproCategoryGenreList) {
    return new GetComproCategoryGenreListResponse(comproCategoryGenreList);
  }
}
