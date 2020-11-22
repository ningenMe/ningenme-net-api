package ningenme.net.api.infrastructure.mysql.mapper;

import ningenme.net.api.infrastructure.mysql.dto.AtcoderUserHistoryMysqlDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AtcoderUserHistoryMysqlMapper {
  public void put(AtcoderUserHistoryMysqlDto atcoderUserHistoryMysqlDto);
}
