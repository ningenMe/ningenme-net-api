package ningenme.net.api.category.application.controller.genrelistwithtopicget;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.application.controller.genrelistwithtopicget.view.GenreView;
import ningenme.net.api.category.domain.entity.Genre;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetListWithTopicList")
public class GenreListWithTopicGetResponse {
  private final List<GenreView> genres;
  public static GenreListWithTopicGetResponse of(@NonNull List<Genre> genres) {
    return new GenreListWithTopicGetResponse(
            genres
                    .stream()
                    .map(
                            comproCategoryGenre -> GenreView.of(comproCategoryGenre)
                    )
                    .collect(Collectors.toList())
    );
  }
}
