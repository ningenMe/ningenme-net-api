package ningenme.net.api.infrastructure.mysql;

import ningenme.net.api.domain.entity.ComproContest;
import ningenme.net.api.domain.repository.ComproContestMysqlRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ComproContestMysqlRepositoryImpl implements ComproContestMysqlRepository {
  @Override
  public void put(ComproContest comproContest) {
  }
}
