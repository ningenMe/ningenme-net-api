package ningenme.net.api.category.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Task;
import ningenme.net.api.category.infrastructure.mysql.dto.TaskMysqlDto;
import ningenme.net.api.category.infrastructure.mysql.mapper.TaskMysqlMapper;
import ningenme.net.api.domain.exception.InsertMysqlException;
import ningenme.net.api.domain.exception.SelectMysqlException;
import ningenme.net.api.category.domain.repository.TaskMysqlRepository;
import ningenme.net.api.domain.value.Url;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TaskMysqlMysqlRepositoryImpl implements TaskMysqlRepository {
  private final SqlSessionTemplate sqlSessionTemplate;

  @Override
  public List<Task> getList(Integer offset) {
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
  public Task getOne(String taskId) {
    try {
      return sqlSessionTemplate.getMapper(TaskMysqlMapper.class).selectOne(taskId).convertComproCategoryTask();
    }
    catch (Exception ex) {
      throw new SelectMysqlException(ex);
    }
  }

  @Override
  public List<Task> getListByTopicId(String topicId) {
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
  public void put(Task task) {
    try {
      sqlSessionTemplate.getMapper(TaskMysqlMapper.class).update(
              TaskMysqlDto.of(task)
      );
    }
    catch (Exception ex) {
      throw new InsertMysqlException(ex);
    }
  }

  @Override
  public void post(Task task) {
    try {
      sqlSessionTemplate.getMapper(TaskMysqlMapper.class).insert(
              TaskMysqlDto.of(task)
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
