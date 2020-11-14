package ningenme.net.api.domain.entity;

import io.swagger.annotations.ApiModelProperty;
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
  @ApiModelProperty(position = 0)
  private final Integer topicId;
  @NonNull
  @ApiModelProperty(position = 1)
  private final String topicName;
  @NonNull
  @ApiModelProperty(position = 2)
  private final CategoryOrder topicOrder;
  @NonNull
  @ApiModelProperty(position = 3)
  private final Integer genreId;
  @ApiModelProperty(position = 4)
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
