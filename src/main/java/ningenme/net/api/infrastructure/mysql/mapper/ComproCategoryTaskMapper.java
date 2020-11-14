package ningenme.net.api.infrastructure.mysql.mapper;

import ningenme.net.api.infrastructure.dto.ComproCategoryTaskDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ComproCategoryTaskMapper {
  List<ComproCategoryTaskDto> selectList(@Param("offset") Integer offset);
  ComproCategoryTaskDto selectOne(@Param("taskId") Integer taskId);
}
