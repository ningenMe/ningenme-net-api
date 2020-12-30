package ningenme.net.api.infrastructure.client;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.AtcoderUserHistory;
import ningenme.net.api.domain.repository.AtcoderUserHistoryClientRepository;
import ningenme.net.api.domain.value.*;
import ningenme.net.api.infrastructure.client.dto.AtcoderUserHistoryClientDto;
import ningenme.net.api.infrastructure.client.mapper.AtcoderUserHistoryClientMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AtcoderUserHistoryClientRepositoryImpl implements AtcoderUserHistoryClientRepository {
  private final AtcoderUserHistoryClientMapper atcoderUserHistoryMapper;
  @Override
  public List<AtcoderUserHistory> get(AtcoderId atcoderId) {
    List<AtcoderUserHistoryClientDto> atcoderUserHistoryClientDtoList = atcoderUserHistoryMapper.get(atcoderId.getValue());
    return atcoderUserHistoryClientDtoList
            .stream()
            .map(atcoderUserHistoryClientDto -> AtcoderUserHistory
                            .builder()
                            .atcoderId(atcoderId)
                            .contestId(ContestId.of(atcoderUserHistoryClientDto.getContestScreenName()))
                            .isRated(atcoderUserHistoryClientDto.getIsRated())
                            .place(Place.of(atcoderUserHistoryClientDto.getPlace()))
                            .oldRate(Rate.of(atcoderUserHistoryClientDto.getOldRating()))
                            .newRate(Rate.of(atcoderUserHistoryClientDto.getNewRating()))
                            .performance(Performance.of(atcoderUserHistoryClientDto.getPerformance()))
                            .build()
            )
            .collect(Collectors.toList());
  }
}
