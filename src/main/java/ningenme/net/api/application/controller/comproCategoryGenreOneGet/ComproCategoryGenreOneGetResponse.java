package ningenme.net.api.application.controller.comproCategoryGenreOneGet;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.controller.comproCategoryGenreOneGet.view.ComproCategoryGenreView;
import ningenme.net.api.domain.entity.ComproCategoryGenre;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetOne")
public class ComproCategoryGenreOneGetResponse {
  private final ComproCategoryGenreView comproCategoryGenre;
  public static ComproCategoryGenreOneGetResponse of(@NonNull ComproCategoryGenre argComproCategoryGenre) {
    return new ComproCategoryGenreOneGetResponse(ComproCategoryGenreView.of(argComproCategoryGenre));
  }
}
