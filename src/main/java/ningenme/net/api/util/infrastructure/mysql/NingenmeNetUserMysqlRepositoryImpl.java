package ningenme.net.api.util.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.util.domain.entity.NingenmeNetUser;
import ningenme.net.api.util.infrastructure.mysql.dto.NingenmeNetUserMysqlDto;
import ningenme.net.api.util.domain.exception.InsertComproCategoryUserException;
import ningenme.net.api.util.domain.exception.SelectMysqlException;
import ningenme.net.api.util.domain.repository.NingenmeNetUserMysqlRepository;
import ningenme.net.api.util.domain.value.Email;
import ningenme.net.api.util.infrastructure.mysql.mapper.NingenmeNetUserMysqlMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NingenmeNetUserMysqlRepositoryImpl implements NingenmeNetUserMysqlRepository {
  private final SqlSessionTemplate sqlSessionTemplate;

  @Override
  public void insert(NingenmeNetUser ningenmeNetUser) {
    try{
      sqlSessionTemplate.getMapper(NingenmeNetUserMysqlMapper.class).insert(
              ningenmeNetUser.getEmail().toString(),
              ningenmeNetUser.getPassword().toString()
      );
    }
    catch (Exception ex) {
      throw new InsertComproCategoryUserException(ex);
    }
  }

  @Override
  public NingenmeNetUser get(Email email) {
    try{
      NingenmeNetUserMysqlDto ningenmeNetUserMysqlDto = sqlSessionTemplate.getMapper(NingenmeNetUserMysqlMapper.class).select(email.toString());
      return ningenmeNetUserMysqlDto.convertComproCategoryUser();
    }
    catch (Exception ex) {
      throw new SelectMysqlException(ex);
    }
  }
}
