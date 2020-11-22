package ningenme.net.api.infrastructure.mysql.mapper;

import ningenme.net.api.infrastructure.mysql.dto.ComproCategoryTopicTaskDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ComproCategoryTopicTaskMapper {
  void insert(ComproCategoryTopicTaskDto comproCategoryTopicTaskDto);
  void deleteByTaskId(String taskId);
}
