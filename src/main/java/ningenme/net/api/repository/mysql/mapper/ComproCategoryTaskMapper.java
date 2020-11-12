package ningenme.net.api.repository.mysql.mapper;

import ningenme.net.api.repository.dto.ComproCategoryTaskDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ComproCategoryTaskMapper {
  List<ComproCategoryTaskDto> select(@Param("offset") Integer offset);
}
