package ningenme.net.api.compro.infrastructure.atcoder;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.compro.domain.entity.AtcoderUserHistory;
import ningenme.net.api.compro.infrastructure.atcoder.dto.AtcoderUserHistoryAtcoderDto;
import ningenme.net.api.compro.infrastructure.atcoder.mapper.AtcoderUserHistoryAtcoderMapper;
import ningenme.net.api.domain.repository.AtcoderUserHistoryClientRepository;
import ningenme.net.api.domain.value.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AtcoderUserHistoryAtcoderRepositoryImpl implements AtcoderUserHistoryClientRepository {
  private final AtcoderUserHistoryAtcoderMapper atcoderUserHistoryMapper;
  @Override
  public List<AtcoderUserHistory> get(AtcoderId atcoderId) {
    List<AtcoderUserHistoryAtcoderDto> atcoderUserHistoryAtcoderDtoList = atcoderUserHistoryMapper.get(atcoderId.getValue());
    return atcoderUserHistoryAtcoderDtoList
            .stream()
            .map(atcoderUserHistoryAtcoderDto -> AtcoderUserHistory
                            .builder()
                            .atcoderId(atcoderId)
                            .contestId(ContestId.of(atcoderUserHistoryAtcoderDto.getContestScreenName()))
                            .isRated(atcoderUserHistoryAtcoderDto.getIsRated())
                            .place(Place.of(atcoderUserHistoryAtcoderDto.getPlace()))
                            .oldRate(Rate.of(atcoderUserHistoryAtcoderDto.getOldRating()))
                            .newRate(Rate.of(atcoderUserHistoryAtcoderDto.getNewRating()))
                            .performance(Performance.of(atcoderUserHistoryAtcoderDto.getPerformance()))
                            .build()
            )
            .collect(Collectors.toList());
  }
}
