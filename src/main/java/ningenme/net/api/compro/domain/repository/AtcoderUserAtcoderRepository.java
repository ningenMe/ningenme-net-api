package ningenme.net.api.compro.domain.repository;

import ningenme.net.api.compro.domain.entity.AtcoderUser;

import java.util.List;

public interface AtcoderUserAtcoderRepository {
  public List<AtcoderUser> get(Integer pageNum);
  public Integer getAllPageNum();
}
