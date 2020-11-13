package ningenme.net.api.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.CategoryOrder;
import ningenme.net.api.domain.value.Label;

import java.sql.Timestamp;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ComproCategoryGenre {

  @NonNull
  private final Integer genreId;
  @NonNull
  private final String genreName;
  @NonNull
  private final Label label;
  @NonNull
  private final CategoryOrder genreOrder;

  public static ComproCategoryGenre of(
          Integer genreId,
          String genreName,
          Label label,
          CategoryOrder genreOrder
  ) {
    return new ComproCategoryGenre(genreId,genreName,label,genreOrder);
  }
  public String getLabel() {
    return label.getValue();
  }
  public Integer getGenreOrder() {
    return genreOrder.getValue();
  }
}
