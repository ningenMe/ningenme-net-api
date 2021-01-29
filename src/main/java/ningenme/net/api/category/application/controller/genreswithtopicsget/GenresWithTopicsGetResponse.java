package ningenme.net.api.category.application.controller.genreswithtopicsget;

import io.swagger.annotations.ApiModel;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.application.controller.genreswithtopicsget.view.GenreView;
import ningenme.net.api.category.domain.entity.Genre;


@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "GenresWithTopics-Get")
public class GenresWithTopicsGetResponse {
  private final List<GenreView> genres;
  public static GenresWithTopicsGetResponse of(@NonNull List<Genre> genres) {
    return new GenresWithTopicsGetResponse(
            genres.stream().map(GenreView::of).collect(Collectors.toList())
    );
  }
}
