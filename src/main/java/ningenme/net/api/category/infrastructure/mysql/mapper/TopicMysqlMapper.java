package ningenme.net.api.category.infrastructure.mysql.mapper;

import ningenme.net.api.category.infrastructure.mysql.dto.TopicMysqlDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TopicMysqlMapper {
  List<TopicMysqlDto> select(@Param("topicId") String topicId);
}
