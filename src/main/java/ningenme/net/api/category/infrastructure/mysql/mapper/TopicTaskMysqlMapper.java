package ningenme.net.api.category.infrastructure.mysql.mapper;

import ningenme.net.api.category.infrastructure.mysql.dto.TopicTaskMysqlDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicTaskMysqlMapper {
  void insert(TopicTaskMysqlDto topicTaskMysqlDto);
  void deleteByTaskId(String taskId);
}
