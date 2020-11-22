package ningenme.net.api.infrastructure.mysql.mapper;

import ningenme.net.api.domain.entity.AtcoderUser;
import ningenme.net.api.infrastructure.dto.AtcoderUserMysqlDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AtcoderUserMapper {
  public void replaceOnlyId(AtcoderUserMysqlDto atcoderUserMysqlDto);
  public AtcoderUserMysqlDto selectLatestOne();
}
