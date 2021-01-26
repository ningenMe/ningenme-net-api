package ningenme.net.api.domain.repository;

import ningenme.net.api.compro.domain.entity.AtcoderUser;

import java.util.List;

public interface AtcoderUserClientRepository {
  public List<AtcoderUser> get(Integer pageNum);
  public Integer getAllPageNum();
}
