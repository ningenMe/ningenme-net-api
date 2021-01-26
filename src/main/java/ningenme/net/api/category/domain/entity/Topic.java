package ningenme.net.api.category.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.CategoryOrder;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Topic {
  @NonNull
  @ApiModelProperty(position = 0)
  private final String topicId;
  @NonNull
  @ApiModelProperty(position = 1)
  private final String topicName;
  @NonNull
  @ApiModelProperty(position = 2)
  private final CategoryOrder topicOrder;
  @NonNull
  @ApiModelProperty(position = 3)
  private final String genreId;
  @ApiModelProperty(position = 4)
  private String genreName;
  @ApiModelProperty(position = 5)
  private List<Task> taskList;

  public static Topic of(
          String topicId,
          String topicName,
          CategoryOrder topicOrder,
          String genreId
  ) {
    return new Topic(topicId, topicName,topicOrder,genreId);
  }
  public void setGenreName(List<Genre> genreList) {
    for (Genre genre : genreList) {
      if(genre.getGenreId().equals(genreId)) {
        genreName = genre.getGenreName();
        return;
      }
    }
  }
  public void setTaskList(List<Task> taskList) {
    this.taskList = taskList;
  }
}
