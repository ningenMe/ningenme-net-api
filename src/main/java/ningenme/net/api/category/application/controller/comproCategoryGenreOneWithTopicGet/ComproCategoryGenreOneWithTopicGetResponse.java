package ningenme.net.api.category.application.controller.comproCategoryGenreOneWithTopicGet;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.application.controller.comproCategoryGenreOneWithTopicGet.view.ComproCategoryGenreView;
import ningenme.net.api.domain.entity.ComproCategoryGenre;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetOneWithTopic")
public class ComproCategoryGenreOneWithTopicGetResponse {
  private final ComproCategoryGenreView comproCategoryGenre;
  public static ComproCategoryGenreOneWithTopicGetResponse of(@NonNull ComproCategoryGenre argComproCategoryGenre) {
    return new ComproCategoryGenreOneWithTopicGetResponse(ComproCategoryGenreView.of(argComproCategoryGenre));
  }
}
