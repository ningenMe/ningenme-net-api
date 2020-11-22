package ningenme.net.api.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.AtcoderUserHistory;
import ningenme.net.api.domain.exception.InsertMysqlException;
import ningenme.net.api.domain.repository.AtcoderUserHistoryMysqlRepository;
import ningenme.net.api.infrastructure.mysql.dto.AtcoderUserHistoryMysqlDto;
import ningenme.net.api.infrastructure.mysql.mapper.AtcoderUserHistoryMysqlMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AtcoderUserHistoryMysqlRepositoryImpl implements AtcoderUserHistoryMysqlRepository {

  private final SqlSessionTemplate sqlSessionTemplate;

  @Override
  public void put(AtcoderUserHistory atcoderUserHistory) {
    try {
      sqlSessionTemplate.getMapper(AtcoderUserHistoryMysqlMapper.class).put(AtcoderUserHistoryMysqlDto.of(atcoderUserHistory));
    }
    catch (Exception ex) {
      throw new InsertMysqlException(ex);
    }
  }
}
