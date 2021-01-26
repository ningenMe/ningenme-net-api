package ningenme.net.api.compro.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.compro.domain.entity.AtcoderUser;
import ningenme.net.api.compro.infrastructure.mysql.mapper.AtcoderUserMysqlMapper;
import ningenme.net.api.util.domain.exception.InsertMysqlException;
import ningenme.net.api.util.domain.exception.NoResourceException;
import ningenme.net.api.util.domain.exception.SelectMysqlException;
import ningenme.net.api.compro.domain.repository.AtcoderUserMysqlRepository;
import ningenme.net.api.domain.value.AtcoderId;
import ningenme.net.api.compro.infrastructure.mysql.dto.AtcoderUserMysqlDto;
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
              .getMapper(AtcoderUserMysqlMapper.class)
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
              .getMapper(AtcoderUserMysqlMapper.class)
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
              .getMapper(AtcoderUserMysqlMapper.class)
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
      return sqlSessionTemplate.getMapper(AtcoderUserMysqlMapper.class).selectOldestOne().convertAtcoderUser();
    }
    catch (Exception ex) {
      throw new SelectMysqlException(ex);
    }
  }

  @Override
  public AtcoderUser getOne(AtcoderId atcoderId) {
    AtcoderUserMysqlDto atcoderUserMysqlDto;
    try {
      atcoderUserMysqlDto = sqlSessionTemplate.getMapper(AtcoderUserMysqlMapper.class).selectOne(atcoderId.getValue());
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
