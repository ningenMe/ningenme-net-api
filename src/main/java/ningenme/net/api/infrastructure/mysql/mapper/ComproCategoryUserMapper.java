package ningenme.net.api.infrastructure.mysql.mapper;

import ningenme.net.api.infrastructure.dto.ComproCategoryUserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ComproCategoryUserMapper {
  void insert(@Param("email") String email, @Param("password") String password);
  ComproCategoryUserDto select(@Param("email") String email);
}
