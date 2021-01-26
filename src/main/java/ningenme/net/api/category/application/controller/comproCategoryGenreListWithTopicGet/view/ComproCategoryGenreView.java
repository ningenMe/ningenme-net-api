package ningenme.net.api.category.application.controller.comproCategoryGenreListWithTopicGet.view;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;

import java.util.List;
import java.util.stream.Collectors;

/**
 * レスポンス時のDTO, プリミティブ型のメンバのみで構成する
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetListComproCategoryGenreResponseDto")
public class ComproCategoryGenreView {
  private final String genreId;
  private final String genreName;
  private final String label;
  private final Integer genreOrder;
  private final List<ComproCategoryTopicView> comproCategoryTopicList;
  public static ComproCategoryGenreView of(ComproCategoryGenre comproCategoryGenre) {
    return new ComproCategoryGenreView(
            comproCategoryGenre.getGenreId(),
            comproCategoryGenre.getGenreName(),
            comproCategoryGenre.getLabel().getValue(),
            comproCategoryGenre.getGenreOrder().getValue(),
            comproCategoryGenre.getComproCategoryTopicList()
                    .stream()
                    .map(comproCategoryTopic -> ComproCategoryTopicView.of(comproCategoryTopic))
                    .collect(Collectors.toList())
    );
  }
}
