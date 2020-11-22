package ningenme.net.api.domain.repository;

import ningenme.net.api.domain.entity.AtcoderUser;
import ningenme.net.api.domain.value.AtcoderId;

import java.util.List;

public interface AtcoderUserClientRepository {
  public List<AtcoderUser> get(Integer pageNum);
  public Integer getAllPageNum();
  public AtcoderUser getOne(AtcoderId atcoderId);
}
