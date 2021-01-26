package ningenme.net.api.util.infrastructure.mysql.mapper;

import ningenme.net.api.util.infrastructure.mysql.dto.BatchMysqlDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BatchMysqlMapper {
  void update(String name, String info);
  BatchMysqlDto select(String name);
}
