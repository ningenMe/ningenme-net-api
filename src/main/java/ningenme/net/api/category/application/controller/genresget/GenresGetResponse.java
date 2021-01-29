package ningenme.net.api.category.application.controller.genresget;

import io.swagger.annotations.ApiModel;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.application.controller.genresget.view.GenreView;
import ningenme.net.api.category.domain.entity.Genre;


@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "Genres-Get")
public class GenresGetResponse {
  private final List<GenreView> genres;

  public static GenresGetResponse of(@NonNull List<Genre> genres) {
    return new GenresGetResponse(
            genres.stream().map(GenreView::of).collect(Collectors.toList())
    );
  }
}
