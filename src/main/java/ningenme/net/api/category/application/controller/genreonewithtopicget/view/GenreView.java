package ningenme.net.api.category.application.controller.genreonewithtopicget.view;

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
@ApiModel(value = "ComproCategoryGenreGetOneWithTopicComproCategoryGenreResponseDto")
public class GenreView {
  private final String genreId;
  private final String genreName;
  private final String label;
  private final Integer genreOrder;
  private final List<TopicView> topics;
  public static GenreView of(ComproCategoryGenre comproCategoryGenre) {
    return new GenreView(
            comproCategoryGenre.getGenreId(),
            comproCategoryGenre.getGenreName(),
            comproCategoryGenre.getLabel().getValue(),
            comproCategoryGenre.getGenreOrder().getValue(),
            comproCategoryGenre.getComproCategoryTopicList()
                    .stream()
                    .map(comproCategoryTopic -> TopicView.of(comproCategoryTopic))
                    .collect(Collectors.toList())
    );
  }
}
