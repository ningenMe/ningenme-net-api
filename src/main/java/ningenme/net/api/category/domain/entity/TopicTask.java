package ningenme.net.api.category.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class TopicTask {
  private final String topicId;
  private final String taskId;
  public static TopicTask of(String topicId, String taskId) {
    return new TopicTask(topicId,taskId);
  }

}
