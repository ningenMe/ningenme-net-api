package ningenme.net.api.category.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.value.CategoryOrder;
import ningenme.net.api.category.domain.value.Label;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Genre {

  @NonNull
  @ApiModelProperty(position = 0)
  private final String genreId;
  @NonNull
  @ApiModelProperty(position = 1)
  private final String genreName;
  @NonNull
  @ApiModelProperty(position = 2)
  private final Label label;
  @NonNull
  @ApiModelProperty(value = "uriに用いるuniqueな識別子",position = 3)
  private final CategoryOrder genreOrder;

  @ApiModelProperty(value = "配下のtopicのリスト",position = 4)
  private List<Topic> topicList;

  public static Genre of(
          String genreId,
          String genreName,
          Label label,
          CategoryOrder genreOrder
  ) {
    return new Genre(genreId,genreName,label,genreOrder);
  }
  public void setTopicList(List<Topic> masterTopicList) {
    List<Topic> tmpTopicList = new ArrayList<>();
    for (Topic topic : masterTopicList) {
      if(Objects.equals(genreId, topic.getGenreId())) {
        tmpTopicList.add(topic);
      }
    }
    tmpTopicList.sort(Comparator.comparing(Topic::getTopicOrder));
    topicList = tmpTopicList;
  }
}
