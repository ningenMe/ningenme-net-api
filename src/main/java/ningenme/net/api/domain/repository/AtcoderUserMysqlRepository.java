package ningenme.net.api.domain.repository;

import ningenme.net.api.domain.entity.AtcoderUser;
import ningenme.net.api.domain.value.AtcoderId;

public interface AtcoderUserMysqlRepository {
  public void put(AtcoderUser atcoderUser);
  public void putId(AtcoderUser atcoderUser);
  public void delete(AtcoderUser atcoderUser);
  public AtcoderUser getOldestOne();
  public AtcoderUser getOne(AtcoderId atcoderId);
}
