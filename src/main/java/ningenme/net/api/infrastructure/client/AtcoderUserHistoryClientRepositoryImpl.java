package ningenme.net.api.infrastructure.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.AtcoderUserHistory;
import ningenme.net.api.domain.repository.AtcoderUserHistoryClientRepository;
import ningenme.net.api.domain.value.*;
import ningenme.net.api.infrastructure.client.dto.AtcoderUserHistoryClientDto;
import ningenme.net.api.infrastructure.client.mapper.AtcoderUserHistoryClientMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AtcoderUserHistoryClientRepositoryImpl implements AtcoderUserHistoryClientRepository {
  private final AtcoderUserHistoryClientMapper atcoderUserHistoryMapper;
  @Override
  public List<AtcoderUserHistory> get(AtcoderId atcoderId) {
    List<AtcoderUserHistoryClientDto> atcoderUserHistoryClientDtoList = atcoderUserHistoryMapper.get(atcoderId.getValue());
    return atcoderUserHistoryClientDtoList
            .stream()
            .map(atcoderUserHistoryClientDto -> AtcoderUserHistory.of(
                    atcoderId,
                    ContestId.of(atcoderUserHistoryClientDto.getContestScreenName()),
                    atcoderUserHistoryClientDto.getIsRated(),
                    Place.of(atcoderUserHistoryClientDto.getPlace()),
                    Rate.of(atcoderUserHistoryClientDto.getOldRating()),
                    Rate.of(atcoderUserHistoryClientDto.getNewRating()),
                    Performance.of(atcoderUserHistoryClientDto.getPerformance())
            ))
            .collect(Collectors.toList());
  }
}
