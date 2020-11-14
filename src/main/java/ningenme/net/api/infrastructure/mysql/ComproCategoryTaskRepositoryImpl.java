package ningenme.net.api.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTask;
import ningenme.net.api.domain.exception.SelectMysqlException;
import ningenme.net.api.domain.repository.ComproCategoryTaskRepository;
import ningenme.net.api.infrastructure.dto.ComproCategoryTaskDto;
import ningenme.net.api.infrastructure.mysql.mapper.ComproCategoryTaskMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ComproCategoryTaskRepositoryImpl implements ComproCategoryTaskRepository {
  private final SqlSessionTemplate sqlSessionTemplate;

  @Override
  public List<ComproCategoryTask> getList(Integer offset) {
    try{
      List<ComproCategoryTaskDto> comproCategoryTaskDtoList = sqlSessionTemplate.getMapper(ComproCategoryTaskMapper.class).selectList(offset);
      return comproCategoryTaskDtoList
              .stream()
              .map(comproCategoryTaskDto -> comproCategoryTaskDto.convertComproCategoryTask())
              .collect(Collectors.toList());
    }
    catch (Exception ex) {
      throw new SelectMysqlException(ex);
    }
  }

  @Override
  public ComproCategoryTask getOne(Integer taskId) {
    try {
      return sqlSessionTemplate.getMapper(ComproCategoryTaskMapper.class).selectOne(taskId).convertComproCategoryTask();
    }
    catch (Exception ex) {
      throw new SelectMysqlException(ex);
    }
  }

  @Override
  public List<ComproCategoryTask> getListByTopicId(Integer topicId) {
    try{
      List<ComproCategoryTaskDto> comproCategoryTaskDtoList
              = sqlSessionTemplate
              .getMapper(ComproCategoryTaskMapper.class)
              .selectListWithTopicId(topicId);

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
