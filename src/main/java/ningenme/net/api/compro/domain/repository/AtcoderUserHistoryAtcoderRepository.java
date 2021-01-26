package ningenme.net.api.compro.domain.repository;

import ningenme.net.api.compro.domain.entity.AtcoderUserHistory;
import ningenme.net.api.compro.domain.value.AtcoderId;

import java.util.List;

public interface AtcoderUserHistoryAtcoderRepository {
  public List<AtcoderUserHistory> get(AtcoderId atcoderId);
}
