package ningenme.net.api.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.exception.InsertMysqlException;
import ningenme.net.api.domain.exception.SelectMysqlException;
import ningenme.net.api.domain.repository.BatchMysqlRepository;
import ningenme.net.api.infrastructure.mysql.mapper.BatchMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BatchMysqlRepositoryImpl implements BatchMysqlRepository {
  private final SqlSessionTemplate sqlSessionTemplate;

  @Override
  public void put(String name, String info) {
    try {
      sqlSessionTemplate.getMapper(BatchMapper.class).update(name,info);
    }
    catch (Exception ex) {
      throw new InsertMysqlException(ex);
    }
  }
  @Override
  public String get(String name) {
    try {
      return sqlSessionTemplate.getMapper(BatchMapper.class).select(name).getInfo();
    }
    catch (Exception ex) {
      throw new SelectMysqlException(ex);
    }
  }

}
