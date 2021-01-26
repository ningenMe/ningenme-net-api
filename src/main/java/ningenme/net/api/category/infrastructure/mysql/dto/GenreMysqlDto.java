package ningenme.net.api.category.infrastructure.mysql.dto;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;
import ningenme.net.api.domain.value.CategoryOrder;
import ningenme.net.api.domain.value.Label;

@RequiredArgsConstructor
public class GenreMysqlDto {
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
