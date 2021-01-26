package ningenme.net.api.util.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.exception.InsertMysqlException;
import ningenme.net.api.domain.exception.SelectMysqlException;
import ningenme.net.api.domain.repository.BatchMysqlRepository;
import ningenme.net.api.util.infrastructure.mysql.mapper.BatchMysqlMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BatchMysqlRepositoryImpl implements BatchMysqlRepository {
  private final SqlSessionTemplate sqlSessionTemplate;

  @Override
  public void put(String name, String info) {
    try {
      sqlSessionTemplate.getMapper(BatchMysqlMapper.class).update(name,info);
    }
    catch (Exception ex) {
      throw new InsertMysqlException(ex);
    }
  }
  @Override
  public String get(String name) {
    try {
      return sqlSessionTemplate.getMapper(BatchMysqlMapper.class).select(name).getInfo();
    }
    catch (Exception ex) {
      throw new SelectMysqlException(ex);
    }
  }

}
