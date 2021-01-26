package ningenme.net.api.category.infrastructure.mysql.mapper;

import ningenme.net.api.category.infrastructure.mysql.dto.CountMysqlDto;
import ningenme.net.api.category.infrastructure.mysql.dto.TaskMysqlDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskMysqlMapper {
  List<TaskMysqlDto> selectList(@Param("offset") Integer offset);
  List<TaskMysqlDto> selectListWithTopicId(@Param("topicId") String topicId);
  TaskMysqlDto selectOne(@Param("taskId") String taskId);
  CountMysqlDto selectCountByUrl(@Param("url") String url);
  CountMysqlDto selectCount();
  void insert(TaskMysqlDto taskMysqlDto);
  void update(TaskMysqlDto taskMysqlDto);
}
