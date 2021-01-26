package ningenme.net.api.util.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.util.infrastructure.mysql.dto.UserMysqlDto;
import ningenme.net.api.domain.entity.ComproCategoryUser;
import ningenme.net.api.domain.exception.InsertComproCategoryUserException;
import ningenme.net.api.domain.exception.SelectMysqlException;
import ningenme.net.api.domain.repository.ComproCategoryUserRepository;
import ningenme.net.api.domain.value.Email;
import ningenme.net.api.util.infrastructure.mysql.mapper.UserMysqlMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserMysqlRepositoryImpl implements ComproCategoryUserRepository {
  private final SqlSessionTemplate sqlSessionTemplate;

  @Override
  public void insert(ComproCategoryUser comproCategoryUser) {
    try{
      sqlSessionTemplate.getMapper(UserMysqlMapper.class).insert(
              comproCategoryUser.getEmail().toString(),
              comproCategoryUser.getPassword().toString()
      );
    }
    catch (Exception ex) {
      throw new InsertComproCategoryUserException(ex);
    }
  }

  @Override
  public ComproCategoryUser get(Email email) {
    try{
      UserMysqlDto userMysqlDto = sqlSessionTemplate.getMapper(UserMysqlMapper.class).select(email.toString());
      return userMysqlDto.convertComproCategoryUser();
    }
    catch (Exception ex) {
      throw new SelectMysqlException(ex);
    }
  }
}
