package ningenme.net.api.repository.mysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTask;
import ningenme.net.api.domain.exception.SelectMysqlException;
import ningenme.net.api.domain.repository.ComproCategoryTaskRepository;
import ningenme.net.api.repository.dto.ComproCategoryTaskDto;
import ningenme.net.api.repository.mysql.mapper.ComproCategoryTaskMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ComproCategoryTaskRepositoryImpl implements ComproCategoryTaskRepository {
  private final SqlSessionTemplate sqlSessionTemplate;

  @Override
  public List<ComproCategoryTask> get(Integer offset) {
    try{
      List<ComproCategoryTaskDto> comproCategoryTaskDtoList = sqlSessionTemplate.getMapper(ComproCategoryTaskMapper.class).select(offset);
      return comproCategoryTaskDtoList
              .stream()
              .map(comproCategoryTaskDto -> comproCategoryTaskDto.convertComproCategoryTask())
              .collect(Collectors.toList());
    }
    catch (Exception ex) {
      throw new SelectMysqlException(ex);
    }
  }
}
