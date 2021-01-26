package ningenme.net.api.compro.infrastructure.mysql.mapper;

import ningenme.net.api.compro.infrastructure.mysql.dto.AtcoderUserMysqlDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AtcoderUserMysqlMapper {
  public void updateForLatest(AtcoderUserMysqlDto atcoderUserMysqlDto);
  public void replaceOnlyId(AtcoderUserMysqlDto atcoderUserMysqlDto);
  public void delete(AtcoderUserMysqlDto atcoderUserMysqlDto);
  public AtcoderUserMysqlDto selectOldestOne();
  public AtcoderUserMysqlDto selectOne(@Param("atcoderId") String atcoderId);
}
