package ningenme.net.api.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.CategoryOrder;
import ningenme.net.api.domain.value.Label;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ComproCategoryTopic {
  @NonNull
  private final Integer topicId;
  @NonNull
  private final String topicName;
  @NonNull
  private final CategoryOrder topicOrder;
  @NonNull
  private final Integer genreId;
  private String genreName;

  public static ComproCategoryTopic of(
          Integer topicId,
          String topicName,
          CategoryOrder topicOrder,
          Integer genreId
  ) {
    return new ComproCategoryTopic(topicId, topicName,topicOrder,genreId);
  }
  public Integer getTopicOrder() {
    return topicOrder.getValue();
  }
  public void setGenreName(List<ComproCategoryGenre> comproCategoryGenreList) {

    for (ComproCategoryGenre comproCategoryGenre: comproCategoryGenreList) {
      if(comproCategoryGenre.getGenreId().equals(genreId)) {
        genreName = comproCategoryGenre.getGenreName();
        return;
      }
    }

  }
}
