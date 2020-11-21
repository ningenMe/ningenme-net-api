package ningenme.net.api.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.AtcoderUser;
import ningenme.net.api.domain.entity.ComproCategoryTask;
import ningenme.net.api.domain.exception.InsertMysqlException;
import ningenme.net.api.domain.exception.SelectMysqlException;
import ningenme.net.api.domain.repository.AtcoderUserMysqlRepository;
import ningenme.net.api.domain.repository.ComproCategoryTaskRepository;
import ningenme.net.api.domain.value.Url;
import ningenme.net.api.infrastructure.dto.AtcoderUserMysqlDto;
import ningenme.net.api.infrastructure.dto.ComproCategoryTaskDto;
import ningenme.net.api.infrastructure.mysql.mapper.AtcoderUserMapper;
import ningenme.net.api.infrastructure.mysql.mapper.ComproCategoryTaskMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AtcoderUserMysqlRepositoryImpl implements AtcoderUserMysqlRepository {
  private final SqlSessionTemplate sqlSessionTemplate;

  @Override
  public void put(AtcoderUser atcoderUser) {
    try {
      sqlSessionTemplate.getMapper(AtcoderUserMapper.class).replaceOnlyId(AtcoderUserMysqlDto.of(atcoderUser));
    }
    catch (Exception ex) {
      throw new InsertMysqlException(ex);
    }
  }


}
