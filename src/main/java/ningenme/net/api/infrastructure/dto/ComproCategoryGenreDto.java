package ningenme.net.api.infrastructure.dto;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;
import ningenme.net.api.domain.value.CategoryOrder;
import ningenme.net.api.domain.value.Label;

@RequiredArgsConstructor
public class ComproCategoryGenreDto {
  private final Integer genreId;
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
