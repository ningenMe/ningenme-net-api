package ningenme.net.api.util.infrastructure.mysql.mapper;

import ningenme.net.api.util.infrastructure.mysql.dto.NingenmeNetUserMysqlDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface NingenmeNetUserMysqlMapper {
  void insert(@Param("email") String email, @Param("password") String password);
  NingenmeNetUserMysqlDto select(@Param("email") String email);
}
