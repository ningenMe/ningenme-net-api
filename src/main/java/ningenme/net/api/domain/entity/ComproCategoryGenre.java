package ningenme.net.api.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.CategoryOrder;
import ningenme.net.api.domain.value.Label;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ComproCategoryGenre {

  @NonNull
  @ApiModelProperty(position = 0)
  private final Integer genreId;
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
  private List<ComproCategoryTopic> comproCategoryTopicList;

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
  public void setComproCategoryTopicList(List<ComproCategoryTopic> masterComproCategoryTopicList) {
    List<ComproCategoryTopic> tmpComproCategoryTopicList = new ArrayList<>();
    for (ComproCategoryTopic comproCategoryTopic:masterComproCategoryTopicList) {
      if(Objects.equals(genreId,comproCategoryTopic.getGenreId())) {
        tmpComproCategoryTopicList.add(comproCategoryTopic);
      }
    }
    tmpComproCategoryTopicList.sort(Comparator.comparing(ComproCategoryTopic::getTopicOrder));
    comproCategoryTopicList = tmpComproCategoryTopicList;
  }
}
