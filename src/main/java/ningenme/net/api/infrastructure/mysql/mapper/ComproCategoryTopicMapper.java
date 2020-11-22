package ningenme.net.api.infrastructure.mysql.mapper;

import ningenme.net.api.infrastructure.mysql.dto.ComproCategoryTopicDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ComproCategoryTopicMapper {
  List<ComproCategoryTopicDto> select(@Param("topicId") String topicId);
}
