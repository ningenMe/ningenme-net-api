package ningenme.net.api.infrastructure.mysql.mapper;

import ningenme.net.api.infrastructure.dto.BatchMysqlDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BatchMapper {
  void update(String name, String info);
  BatchMysqlDto select(String name);
}
