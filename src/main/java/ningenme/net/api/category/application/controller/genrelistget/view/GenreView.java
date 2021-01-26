package ningenme.net.api.category.application.controller.genrelistget.view;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Genre;

/**
 * レスポンス時のDTO, プリミティブ型のメンバのみで構成する
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetListComproCategoryGenreResponseDto")
public class GenreView {
  private final String genreId;
  private final String genreName;
  private final String label;
  private final Integer genreOrder;
  public static GenreView of(Genre genre) {
    return new GenreView(
            genre.getGenreId(),
            genre.getGenreName(),
            genre.getLabel().getValue(),
            genre.getGenreOrder().getValue()
    );
  }
}
