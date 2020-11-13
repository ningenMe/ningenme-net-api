package ningenme.net.api.repository.dto;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;
import ningenme.net.api.domain.entity.ComproCategoryTask;
import ningenme.net.api.domain.value.CategoryOrder;
import ningenme.net.api.domain.value.Label;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.Url;

import java.sql.Timestamp;

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
