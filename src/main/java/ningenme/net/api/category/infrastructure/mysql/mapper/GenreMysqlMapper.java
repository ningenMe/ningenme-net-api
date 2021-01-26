package ningenme.net.api.category.infrastructure.mysql.mapper;

import ningenme.net.api.category.infrastructure.mysql.dto.GenreMysqlDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GenreMysqlMapper {
  List<GenreMysqlDto> select(@Param("label") String label);
}
