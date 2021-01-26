package ningenme.net.api.compro.infrastructure.mysql.mapper;

import ningenme.net.api.compro.infrastructure.mysql.dto.AtcoderUserHistoryMysqlDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AtcoderUserHistoryMysqlMapper {
  public void put(AtcoderUserHistoryMysqlDto atcoderUserHistoryMysqlDto);
  public List<AtcoderUserHistoryMysqlDto> select(@Param("atcoderId") String atcoderId);
}
