package ningenme.net.api.compro.infrastructure.mysql;

import ningenme.net.api.compro.domain.entity.Contest;
import ningenme.net.api.domain.repository.ComproContestMysqlRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ContestMysqlRepositoryImpl implements ComproContestMysqlRepository {
  @Override
  public void put(Contest contest) {
  }
}
