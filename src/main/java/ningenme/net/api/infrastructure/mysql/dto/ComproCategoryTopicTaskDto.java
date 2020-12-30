package ningenme.net.api.infrastructure.mysql.dto;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class ComproCategoryTopicTaskDto {
  private final String topicId;
  private final String taskId;
}
