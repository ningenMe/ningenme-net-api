package ningenme.net.api.compro.infrastructure.mysql;

import ningenme.net.api.compro.domain.entity.Contest;
import ningenme.net.api.compro.domain.repository.ContestMysqlRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ContestMysqlRepositoryImpl implements ContestMysqlRepository {
  @Override
  public void put(Contest contest) {
  }
}
