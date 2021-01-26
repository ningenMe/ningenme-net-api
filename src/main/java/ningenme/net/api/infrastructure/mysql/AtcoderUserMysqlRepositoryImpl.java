package ningenme.net.api.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.compro.domain.entity.AtcoderUser;
import ningenme.net.api.domain.exception.InsertMysqlException;
import ningenme.net.api.domain.exception.NoResourceException;
import ningenme.net.api.domain.exception.SelectMysqlException;
import ningenme.net.api.domain.repository.AtcoderUserMysqlRepository;
import ningenme.net.api.domain.value.AtcoderId;
import ningenme.net.api.infrastructure.mysql.dto.AtcoderUserMysqlDto;
import ningenme.net.api.infrastructure.mysql.mapper.AtcoderUserMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AtcoderUserMysqlRepositoryImpl implements AtcoderUserMysqlRepository {
  private final SqlSessionTemplate sqlSessionTemplate;

  @Override
  public void put(AtcoderUser atcoderUser) {
    try {
      sqlSessionTemplate
              .getMapper(AtcoderUserMapper.class)
              .updateForLatest(
                      AtcoderUserMysqlDto
                              .builder()
                              .atcoderId(
                                      atcoderUser.getAtcoderId().getValue()
                              )
                              .build()
              );
    }
    catch (Exception ex) {
      throw new InsertMysqlException(ex);
    }
  }

  @Override
  public void putId(AtcoderUser atcoderUser) {
    try {
      sqlSessionTemplate
              .getMapper(AtcoderUserMapper.class)
              .replaceOnlyId(
                      AtcoderUserMysqlDto
                              .builder()
                              .atcoderId(
                                      atcoderUser.getAtcoderId().getValue()
                              )
                              .build()
              );
    }
    catch (Exception ex) {
      throw new InsertMysqlException(ex);
    }
  }

  @Override
  public void delete(AtcoderUser atcoderUser) {
    try {
      sqlSessionTemplate
              .getMapper(AtcoderUserMapper.class)
              .delete(
                      AtcoderUserMysqlDto
                              .builder()
                              .atcoderId(
                                      atcoderUser.getAtcoderId().getValue()
                              )
                              .build()
      );
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

  @Override
  public AtcoderUser getOne(AtcoderId atcoderId) {
    AtcoderUserMysqlDto atcoderUserMysqlDto;
    try {
      atcoderUserMysqlDto = sqlSessionTemplate.getMapper(AtcoderUserMapper.class).selectOne(atcoderId.getValue());
    }
    catch (Exception ex) {
      throw new SelectMysqlException(ex);
    }
    try {
      return atcoderUserMysqlDto.convertAtcoderUser();
    }
    catch (Exception ex) {
      throw new NoResourceException(ex);
    }
  }

}
