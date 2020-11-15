package ningenme.net.api.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.Url;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class ComproCategoryTask {
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
  private List<ComproCategoryTopic> comproCategoryTopicList;

  public static ComproCategoryTask of(
          String taskId,
          String taskName,
          Url url,
          TaskScore score,
          TaskScore estimation,
          List<String> topicIdList,
          Timestamp createdTime
  ) {
    return new ComproCategoryTask(taskId, taskName, url, score, estimation, topicIdList, createdTime);
  }

  public static ComproCategoryTask of(
          String taskId,
          String taskName,
          Url url,
          TaskScore score,
          TaskScore estimation,
          String topicIdListString,
          Timestamp createdTime
  ) {
    return new ComproCategoryTask(taskId,taskName,url,score,estimation,
            Arrays.asList(topicIdListString.split(",")),
            createdTime);
  }

  public void setTopicList(List<ComproCategoryTopic> masterComproCategoryTopicList) {
    //TODO 計算量が悪い そのうちlogに直しましょう
    List<ComproCategoryTopic> tmpComproCategoryTopicList = new ArrayList<>();
    for (String topicId: topicIdList) {
      for (ComproCategoryTopic comproCategoryTopic: masterComproCategoryTopicList) {

        if (Objects.equals(topicId,comproCategoryTopic.getTopicId())) {
          tmpComproCategoryTopicList.add(comproCategoryTopic);
          break;
        }
      }
    }
    comproCategoryTopicList = tmpComproCategoryTopicList;
  }

  public List<ComproCategoryTopicTask> getComproCategoryTopicTaskList() {
    List<ComproCategoryTopicTask> comproCategoryTopicTaskList = new ArrayList<>();
    for (String topicId: topicIdList) {
      comproCategoryTopicTaskList.add(ComproCategoryTopicTask.of(topicId,taskId));
    }
    return comproCategoryTopicTaskList;
  }
}
