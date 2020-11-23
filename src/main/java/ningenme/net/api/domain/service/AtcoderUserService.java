package ningenme.net.api.domain.service;

import ningenme.net.api.domain.entity.AtcoderUser;
import ningenme.net.api.domain.value.AtcoderId;

public interface AtcoderUserService {
  public void putId();
  public void put();
  public AtcoderUser getOne(AtcoderId atcoderId);
}
