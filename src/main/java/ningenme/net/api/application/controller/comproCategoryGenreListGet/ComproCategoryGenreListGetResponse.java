package ningenme.net.api.application.controller.comproCategoryGenreListGet;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.controller.comproCategoryGenreListGet.view.ComproCategoryGenreView;
import ningenme.net.api.domain.entity.ComproCategoryGenre;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetList")
public class ComproCategoryGenreListGetResponse {
  private final List<ComproCategoryGenreView> comproCategoryGenreList;
  public static ComproCategoryGenreListGetResponse of(@NonNull List<ComproCategoryGenre> argComproCategoryGenreList) {
    return new ComproCategoryGenreListGetResponse(
      argComproCategoryGenreList
              .stream()
              .map(
                      comproCategoryGenre -> ComproCategoryGenreView.of(comproCategoryGenre)
              )
            .collect(Collectors.toList())
    );
  }
}
