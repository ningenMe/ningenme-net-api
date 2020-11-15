package ningenme.net.api.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ComproCategoryTopicTask {
  private final String topicId;
  private final String taskId;
  public static ComproCategoryTopicTask of(String topicId,String taskId) {
    return new ComproCategoryTopicTask(topicId,taskId);
  }
}
