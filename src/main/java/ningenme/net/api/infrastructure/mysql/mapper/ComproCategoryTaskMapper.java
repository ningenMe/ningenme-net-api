package ningenme.net.api.infrastructure.mysql.mapper;

import ningenme.net.api.infrastructure.mysql.dto.ComproCategoryTaskDto;
import ningenme.net.api.infrastructure.mysql.dto.CountDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ComproCategoryTaskMapper {
  List<ComproCategoryTaskDto> selectList(@Param("offset") Integer offset);
  List<ComproCategoryTaskDto> selectListWithTopicId(@Param("topicId") String topicId);
  ComproCategoryTaskDto selectOne(@Param("taskId") String taskId);
  CountDto selectCountByUrl(@Param("url") String url);
  CountDto selectCount();
  void insert(ComproCategoryTaskDto comproCategoryTaskDto);
  void update(ComproCategoryTaskDto comproCategoryTaskDto);
}
