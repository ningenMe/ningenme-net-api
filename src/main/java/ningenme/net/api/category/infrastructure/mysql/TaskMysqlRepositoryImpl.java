package ningenme.net.api.category.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.infrastructure.mysql.dto.TaskMysqlDto;
import ningenme.net.api.category.infrastructure.mysql.mapper.TaskMysqlMapper;
import ningenme.net.api.domain.entity.ComproCategoryTask;
import ningenme.net.api.domain.exception.InsertMysqlException;
import ningenme.net.api.domain.exception.SelectMysqlException;
import ningenme.net.api.domain.repository.ComproCategoryTaskRepository;
import ningenme.net.api.domain.value.Url;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TaskMysqlRepositoryImpl implements ComproCategoryTaskRepository {
  private final SqlSessionTemplate sqlSessionTemplate;

  @Override
  public List<ComproCategoryTask> getList(Integer offset) {
    try{
      List<TaskMysqlDto> taskMysqlDtoList = sqlSessionTemplate.getMapper(TaskMysqlMapper.class).selectList(offset);
      return taskMysqlDtoList
              .stream()
              .map(taskMysqlDto -> taskMysqlDto.convertComproCategoryTask())
              .collect(Collectors.toList());
    }
    catch (Exception ex) {
      throw new SelectMysqlException(ex);
    }
  }

  @Override
  public ComproCategoryTask getOne(String taskId) {
    try {
      return sqlSessionTemplate.getMapper(TaskMysqlMapper.class).selectOne(taskId).convertComproCategoryTask();
    }
    catch (Exception ex) {
      throw new SelectMysqlException(ex);
    }
  }

  @Override
  public List<ComproCategoryTask> getListByTopicId(String topicId) {
    try{
      List<TaskMysqlDto> taskMysqlDtoList
              = sqlSessionTemplate
              .getMapper(TaskMysqlMapper.class)
              .selectListWithTopicId(topicId);

      return taskMysqlDtoList
              .stream()
              .map(taskMysqlDto -> taskMysqlDto.convertComproCategoryTask())
              .collect(Collectors.toList());
    }
    catch (Exception ex) {
      throw new SelectMysqlException(ex);
    }
  }

  @Override
  public Integer getCount() {
    try {
      return sqlSessionTemplate.getMapper(TaskMysqlMapper.class).selectCount().getCount();
    }
    catch (Exception ex) {
      throw new SelectMysqlException(ex);
    }
  }

  @Override
  public void put(ComproCategoryTask comproCategoryTask) {
    try {
      sqlSessionTemplate.getMapper(TaskMysqlMapper.class).update(
              TaskMysqlDto.of(comproCategoryTask)
      );
    }
    catch (Exception ex) {
      throw new InsertMysqlException(ex);
    }
  }

  @Override
  public void post(ComproCategoryTask comproCategoryTask) {
    try {
      sqlSessionTemplate.getMapper(TaskMysqlMapper.class).insert(
              TaskMysqlDto.of(comproCategoryTask)
      );
    }
    catch (Exception ex) {
      throw new InsertMysqlException(ex);
    }
  }


  @Override
  public Integer getCountByUrl(Url url) {
    try {
      return sqlSessionTemplate.getMapper(TaskMysqlMapper.class).selectCountByUrl(url.getValue()).getCount();
    }
    catch (Exception ex) {
      throw new SelectMysqlException(ex);
    }
  }


}
