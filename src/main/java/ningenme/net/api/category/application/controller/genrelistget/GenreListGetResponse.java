package ningenme.net.api.category.application.controller.genrelistget;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.application.controller.genrelistget.view.GenreView;
import ningenme.net.api.category.domain.entity.Genre;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetList")
public class GenreListGetResponse {
  private final List<GenreView> genres;
  public static GenreListGetResponse of(@NonNull List<Genre> genres) {
    return new GenreListGetResponse(
            genres
                    .stream()
                    .map(
                            comproCategoryGenre -> GenreView.of(comproCategoryGenre)
                    )
                    .collect(Collectors.toList())
    );
  }
}
