package ningenme.net.api.category.infrastructure.mysql.dto;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Genre;
import ningenme.net.api.category.domain.value.CategoryOrder;
import ningenme.net.api.category.domain.value.Label;

@RequiredArgsConstructor
public class GenreMysqlDto {
  private final String genreId;
  private final String genreName;
  private final String label;
  private final Integer genreOrder;
  public Genre convertComproCategoryGenre() {
    return Genre.of(
            genreId,
            genreName,
            Label.of(label),
            CategoryOrder.of(genreOrder)
    );
  }
}
