package ningenme.net.api.repository.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ningenme.net.api.repository.dto.GenreDto;

@Mapper
public interface GenreMapper {
    List<GenreDto> select(@Param("label") String label);
}