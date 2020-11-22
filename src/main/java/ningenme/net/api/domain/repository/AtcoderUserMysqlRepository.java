package ningenme.net.api.domain.repository;

import ningenme.net.api.domain.entity.AtcoderUser;

public interface AtcoderUserMysqlRepository {
  public void putId(AtcoderUser atcoderUser);
  public AtcoderUser getLatestOne();
}
