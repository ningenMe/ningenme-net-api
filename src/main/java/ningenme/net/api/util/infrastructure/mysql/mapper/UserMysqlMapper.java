package ningenme.net.api.util.infrastructure.mysql.mapper;

import ningenme.net.api.util.infrastructure.mysql.dto.UserMysqlDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMysqlMapper {
  void insert(@Param("email") String email, @Param("password") String password);
  UserMysqlDto select(@Param("email") String email);
}
