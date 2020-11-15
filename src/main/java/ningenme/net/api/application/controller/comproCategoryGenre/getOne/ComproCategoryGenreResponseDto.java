package ningenme.net.api.application.controller.comproCategoryGenre.getOne;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;

/**
 * レスポンス時のDTO, プリミティブ型のメンバのみで構成する
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetOneComproCategoryGenreResponseDto")
public class ComproCategoryGenreResponseDto {
  private final String genreId;
  private final String genreName;
  private final String label;
  private final Integer genreOrder;
  public static ComproCategoryGenreResponseDto of(ComproCategoryGenre comproCategoryGenre) {
    return new ComproCategoryGenreResponseDto(
            comproCategoryGenre.getGenreId(),
            comproCategoryGenre.getGenreName(),
            comproCategoryGenre.getLabel().getValue(),
            comproCategoryGenre.getGenreOrder().getValue()
    );
  }
}
