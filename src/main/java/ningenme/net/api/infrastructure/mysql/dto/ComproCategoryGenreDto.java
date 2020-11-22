package ningenme.net.api.infrastructure.mysql.dto;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;
import ningenme.net.api.domain.value.CategoryOrder;
import ningenme.net.api.domain.value.Label;

@RequiredArgsConstructor
public class ComproCategoryGenreDto {
  private final String genreId;
  private final String genreName;
  private final String label;
  private final Integer genreOrder;
  public ComproCategoryGenre convertComproCategoryGenre() {
    return ComproCategoryGenre.of(
            genreId,
            genreName,
            Label.of(label),
            CategoryOrder.of(genreOrder)
    );
  }
}
