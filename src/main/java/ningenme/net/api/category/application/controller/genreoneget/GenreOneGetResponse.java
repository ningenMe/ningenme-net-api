package ningenme.net.api.category.application.controller.genreoneget;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.application.controller.genreoneget.view.GenreView;
import ningenme.net.api.domain.entity.ComproCategoryGenre;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetOne")
public class GenreOneGetResponse {
  private final GenreView genre;
  public static GenreOneGetResponse of(@NonNull ComproCategoryGenre comproCategoryGenre) {
    return new GenreOneGetResponse(GenreView.of(comproCategoryGenre));
  }
}
