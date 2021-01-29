package ningenme.net.api.category.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.compro.domain.value.TaskScore;
import ningenme.net.api.util.domain.value.Url;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Task {
  @NonNull
  @ApiModelProperty(position = 0)
  private final String taskId;

  @NonNull
  @ApiModelProperty(position = 1)
  private final String taskName;

  @NonNull
  @ApiModelProperty(position = 2)
  private final Url url;

  @NonNull
  @ApiModelProperty(position = 3)
  private final TaskScore score;

  @NonNull
  @ApiModelProperty(value = "推定難易度", position = 4)
  private final TaskScore estimation;

  @NonNull
  @ApiModelProperty(value = "親のtopicIdのリスト", position = 5)
  private final List<String> topicIdList;

  @ApiModelProperty(position = 6)
  private final Timestamp createdTime;

  @ApiModelProperty(value = "親のtopicのリスト", position = 7)
  private List<Topic> topicList;

  public static Task of(
          String taskId,
          String taskName,
          Url url,
          TaskScore score,
          TaskScore estimation,
          List<String> topicIdList,
          Timestamp createdTime
  ) {
    return new Task(taskId, taskName, url, score, estimation, topicIdList, createdTime);
  }

  public static Task of(
          String taskId,
          String taskName,
          Url url,
          TaskScore score,
          TaskScore estimation,
          String topicIdListString,
          Timestamp createdTime
  ) {
    return new Task(taskId,taskName,url,score,estimation,
            Arrays.asList(topicIdListString.split(",")),
            createdTime);
  }

  public void setTopicList(List<Topic> masterTopicList) {
    //TODO 計算量が悪い そのうちlogに直しましょう
    List<Topic> tmpTopicList = new ArrayList<>();
    for (String topicId: topicIdList) {
      for (Topic topic : masterTopicList) {

        if (Objects.equals(topicId, topic.getTopicId())) {
          tmpTopicList.add(topic);
          break;
        }
      }
    }
    topicList = tmpTopicList;
  }

  public List<TopicTask> getComproCategoryTopicTaskList() {
    List<TopicTask> topicTaskList = new ArrayList<>();
    for (String topicId: topicIdList) {
      topicTaskList.add(TopicTask.of(topicId,taskId));
    }
    return topicTaskList;
  }
}
