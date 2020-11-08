package ningenme.net.api.repository.mysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryUser;
import ningenme.net.api.domain.exception.InsertComproCategoryUserException;
import ningenme.net.api.domain.repository.ComproCategoryUserRepository;
import ningenme.net.api.repository.mysql.mapper.ComproCategoryUserMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ComproCategoryUserRepositoryImpl implements ComproCategoryUserRepository {
  private final SqlSessionTemplate sqlSessionTemplate;

  @Override
  public void insert(ComproCategoryUser comproCategoryUser) {
    try{
      sqlSessionTemplate.getMapper(ComproCategoryUserMapper.class).insert(
              comproCategoryUser.getEmail().toString(),
              comproCategoryUser.getPassword().toString()
      );
    }
    catch (Exception ex) {
      throw new InsertComproCategoryUserException(ex);
    }
  }
}
