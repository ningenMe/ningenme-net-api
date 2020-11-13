package ningenme.net.api.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.value.TaskScore;
import ningenme.net.api.domain.value.Url;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class ComproCategoryTask {
  @NonNull
  private final Integer taskId;
  @NonNull
  private final String taskName;
  private final Url url;
  @NonNull
  private final TaskScore score;
  @NonNull
  private final TaskScore estimation;
  @NonNull
  private final List<Integer> topicIdList;

  private final Timestamp createdTime;

  private List<ComproCategoryTopic> comproCategoryTopicList;

  public static ComproCategoryTask of(
          Integer taskId,
          String taskName,
          Url url,
          TaskScore score,
          TaskScore estimation,
          List<Integer> topicIdList,
          Timestamp createdTime
  ) {
    return new ComproCategoryTask(taskId,taskName,url,score,estimation,topicIdList,createdTime);
  }
  public String getUrl() {
    return url.getValue();
  }
  public Integer getScore() {
    return score.getValue();
  }
  public Integer getEstimation() {
    return estimation.getValue();
  }
  public String getCreatedTime() {
    return createdTime.toString();
  }
  public void setTopicList(List<ComproCategoryTopic> masterComproCategoryTopicList) {
    //TODO 計算量が悪い そのうちlogに直しましょう
    List<ComproCategoryTopic> tmpComproCategoryTopicList = new ArrayList<>();
    for (Integer topicId: topicIdList) {
      for (ComproCategoryTopic comproCategoryTopic: masterComproCategoryTopicList) {

        if (Objects.equals(topicId,comproCategoryTopic.getTopicId())) {
          tmpComproCategoryTopicList.add(comproCategoryTopic);
          break;
        }
      }
    }
    comproCategoryTopicList = tmpComproCategoryTopicList;
  }
}
