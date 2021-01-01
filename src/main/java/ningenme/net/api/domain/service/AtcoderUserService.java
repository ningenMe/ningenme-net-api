package ningenme.net.api.domain.service;

import ningenme.net.api.domain.entity.AtcoderUser;
import ningenme.net.api.domain.entity.AtcoderUserHistory;
import ningenme.net.api.domain.value.AtcoderId;
import ningenme.net.api.domain.value.BingoType;

import java.util.List;

public interface AtcoderUserService {
  public void putId();
  public void put();
  public AtcoderUser getOne(AtcoderId atcoderId);
  public List<AtcoderUserHistory> getBingo(AtcoderId atcoderId, BingoType bingoType);
}
