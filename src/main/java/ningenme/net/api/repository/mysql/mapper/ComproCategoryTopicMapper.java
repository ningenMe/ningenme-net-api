package ningenme.net.api.repository.mysql.mapper;

import ningenme.net.api.repository.dto.ComproCategoryTopicDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ComproCategoryTopicMapper {
  List<ComproCategoryTopicDto> select(@Param("topicId") Integer topicId);
}
