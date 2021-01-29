package ningenme.net.api.category.application.controller.genreonewithtopicsget;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.application.controller.genreonewithtopicsget.view.GenreView;
import ningenme.net.api.category.domain.entity.Genre;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "GenreOneWithTopics-Get")
public class GenreOneWithTopicGetResponse {
  private final GenreView genre;

  public static GenreOneWithTopicGetResponse of(@NonNull Genre genre) {
    return new GenreOneWithTopicGetResponse(GenreView.of(genre));
  }
}
