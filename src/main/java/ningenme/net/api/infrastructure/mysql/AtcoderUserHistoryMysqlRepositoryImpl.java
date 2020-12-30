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
      sqlSessionTemplate.getMapper(AtcoderUserHistoryMysqlMapper.class).put(
              AtcoderUserHistoryMysqlDto
                      .builder()
                      .atcoderId(atcoderUserHistory.getAtcoderId().getValue())
                      .contestId(atcoderUserHistory.getContestId().getValue())
                      .isRated(atcoderUserHistory.getIsRated())
                      .place(atcoderUserHistory.getPlace().getValue())
                      .oldRating(atcoderUserHistory.getOldRate().getValue())
                      .newRating(atcoderUserHistory.getNewRate().getValue())
                      .performance(atcoderUserHistory.getPerformance().getValue())
                      .build()
      );
    }
    catch (Exception ex) {
      throw new InsertMysqlException(ex);
    }
  }
}
