package ningenme.net.api.infrastructure.mysql.mapper;

import ningenme.net.api.infrastructure.mysql.dto.AtcoderUserMysqlDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AtcoderUserMapper {
  public void updateForLatest(AtcoderUserMysqlDto atcoderUserMysqlDto);
  public void replaceOnlyId(AtcoderUserMysqlDto atcoderUserMysqlDto);
  public void delete(AtcoderUserMysqlDto atcoderUserMysqlDto);
  public AtcoderUserMysqlDto selectOldestOne();
  public AtcoderUserMysqlDto selectOne(@Param("atcoderId") String atcoderId);
}
