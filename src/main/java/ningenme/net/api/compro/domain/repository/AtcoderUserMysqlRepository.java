package ningenme.net.api.compro.domain.repository;

import ningenme.net.api.compro.domain.entity.AtcoderUser;
import ningenme.net.api.compro.domain.value.AtcoderId;

public interface AtcoderUserMysqlRepository {
  public void put(AtcoderUser atcoderUser);
  public void putId(AtcoderUser atcoderUser);
  public void delete(AtcoderUser atcoderUser);
  public AtcoderUser getOldestOne();
  public AtcoderUser getOne(AtcoderId atcoderId);
}
