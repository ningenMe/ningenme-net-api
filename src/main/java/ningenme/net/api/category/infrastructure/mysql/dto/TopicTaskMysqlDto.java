package ningenme.net.api.category.infrastructure.mysql.dto;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class TopicTaskMysqlDto {
  private final String topicId;
  private final String taskId;
}
