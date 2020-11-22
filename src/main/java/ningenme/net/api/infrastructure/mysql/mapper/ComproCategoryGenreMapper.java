package ningenme.net.api.infrastructure.mysql.mapper;

import ningenme.net.api.infrastructure.mysql.dto.ComproCategoryGenreDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ComproCategoryGenreMapper {
  List<ComproCategoryGenreDto> select(@Param("label") String label);
}
