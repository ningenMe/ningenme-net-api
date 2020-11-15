package ningenme.net.api.infrastructure.dto;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTopicTask;

@RequiredArgsConstructor
public class ComproCategoryTopicTaskDto {
  private final String topicId;
  private final String taskId;

  public static ComproCategoryTopicTaskDto of(ComproCategoryTopicTask comproCategoryTopicTask) {
    return new ComproCategoryTopicTaskDto(comproCategoryTopicTask.getTopicId(), comproCategoryTopicTask.getTaskId());
  }
}
