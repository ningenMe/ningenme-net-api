package ningenme.net.api.domain.repository;

import ningenme.net.api.domain.entity.AtcoderUserHistory;
import ningenme.net.api.domain.value.AtcoderId;

import java.util.List;

public interface AtcoderUserHistoryClientRepository {
  public List<AtcoderUserHistory> get(AtcoderId atcoderId);
}
