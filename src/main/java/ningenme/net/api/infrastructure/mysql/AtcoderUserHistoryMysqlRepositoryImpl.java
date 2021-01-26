package ningenme.net.api.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.compro.domain.entity.AtcoderUserHistory;
import ningenme.net.api.domain.exception.InsertMysqlException;
import ningenme.net.api.domain.exception.SelectMysqlException;
import ningenme.net.api.domain.repository.AtcoderUserHistoryMysqlRepository;
import ningenme.net.api.domain.value.AtcoderId;
import ningenme.net.api.domain.value.ContestId;
import ningenme.net.api.domain.value.Performance;
import ningenme.net.api.domain.value.Place;
import ningenme.net.api.infrastructure.mysql.dto.AtcoderUserHistoryMysqlDto;
import ningenme.net.api.infrastructure.mysql.mapper.AtcoderUserHistoryMysqlMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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

  @Override
  public List<AtcoderUserHistory> get(AtcoderId atcoderId) {
    try {
      List<AtcoderUserHistoryMysqlDto> atcoderUserHistoryMysqlDtos
              = sqlSessionTemplate.getMapper(AtcoderUserHistoryMysqlMapper.class).select(atcoderId.getValue());
      return atcoderUserHistoryMysqlDtos
              .stream()
              .map(atcoderUserHistoryMysqlDto -> AtcoderUserHistory
                      .builder()
                      .atcoderId(AtcoderId.of(atcoderUserHistoryMysqlDto.getAtcoderId()))
                      .contestId(ContestId.of(atcoderUserHistoryMysqlDto.getContestId()))
                      .place(Place.of(atcoderUserHistoryMysqlDto.getPlace()))
                      .performance(Performance.of(atcoderUserHistoryMysqlDto.getPerformance()))
                      .build()
              )
              .collect(Collectors.toList());
    }
    catch (Exception ex) {
      throw new SelectMysqlException(ex);
    }
  }
}
