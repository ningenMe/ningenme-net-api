package ningenme.net.api.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.AtcoderUser;
import ningenme.net.api.domain.exception.InsertMysqlException;
import ningenme.net.api.domain.exception.SelectMysqlException;
import ningenme.net.api.domain.repository.AtcoderUserMysqlRepository;
import ningenme.net.api.infrastructure.mysql.dto.AtcoderUserMysqlDto;
import ningenme.net.api.infrastructure.mysql.mapper.AtcoderUserMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class AtcoderUserMysqlRepositoryImpl implements AtcoderUserMysqlRepository {
  private final SqlSessionTemplate sqlSessionTemplate;

  @Override
  public void putId(AtcoderUser atcoderUser) {
    try {
      sqlSessionTemplate.getMapper(AtcoderUserMapper.class).replaceOnlyId(AtcoderUserMysqlDto.of(atcoderUser.getAtcoderId()));
    }
    catch (Exception ex) {
      throw new InsertMysqlException(ex);
    }
  }

  @Override
  public AtcoderUser getOldestOne() {
    try {
      return sqlSessionTemplate.getMapper(AtcoderUserMapper.class).selectOldestOne().convertAtcoderUser();
    }
    catch (Exception ex) {
      throw new SelectMysqlException(ex);
    }
  }
}
