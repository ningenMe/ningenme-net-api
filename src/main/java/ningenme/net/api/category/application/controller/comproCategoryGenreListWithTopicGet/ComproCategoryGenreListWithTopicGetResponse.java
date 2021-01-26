package ningenme.net.api.category.application.controller.comproCategoryGenreListWithTopicGet;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.application.controller.comproCategoryGenreListWithTopicGet.view.ComproCategoryGenreView;
import ningenme.net.api.domain.entity.ComproCategoryGenre;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetListWithTopicList")
public class ComproCategoryGenreListWithTopicGetResponse {
  private final List<ComproCategoryGenreView> comproCategoryGenreList;
  public static ComproCategoryGenreListWithTopicGetResponse of(@NonNull List<ComproCategoryGenre> argComproCategoryGenreList) {
    return new ComproCategoryGenreListWithTopicGetResponse(
      argComproCategoryGenreList
              .stream()
              .map(
                      comproCategoryGenre -> ComproCategoryGenreView.of(comproCategoryGenre)
              )
            .collect(Collectors.toList())
    );
  }
}
