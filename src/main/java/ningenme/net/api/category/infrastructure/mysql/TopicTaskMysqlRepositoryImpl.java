package ningenme.net.api.category.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.category.infrastructure.mysql.mapper.TopicTaskMysqlMapper;
import ningenme.net.api.domain.entity.ComproCategoryTopicTask;
import ningenme.net.api.domain.repository.ComproCategoryTopicTaskRepository;
import ningenme.net.api.domain.value.LogCode;
import ningenme.net.api.category.infrastructure.mysql.dto.TopicTaskMysqlDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class TopicTaskMysqlRepositoryImpl implements ComproCategoryTopicTaskRepository {
  private final SqlSessionTemplate sqlSessionTemplate;

  @Override
  public void postList(List<ComproCategoryTopicTask> comproCategoryTopicTaskList) {
    for (ComproCategoryTopicTask comproCategoryTopicTask: comproCategoryTopicTaskList) {
      try {
        sqlSessionTemplate.getMapper(TopicTaskMysqlMapper.class).insert(
                TopicTaskMysqlDto
                        .builder()
                        .topicId(comproCategoryTopicTask.getTopicId())
                        .taskId(comproCategoryTopicTask.getTaskId())
                        .build()
        );
      }
      catch (Exception ex) {
        log.info("code={}, message={}", LogCode.API_INFO_206.getCode(),LogCode.API_INFO_206.getMessage());
      }
    }
  }

  @Override
  public void deleteByTaskId(String taskId) {
    try {
      sqlSessionTemplate.getMapper(TopicTaskMysqlMapper.class).deleteByTaskId(taskId);
    }
    catch (Exception ex) {
      log.info("code={}, message={}", LogCode.API_INFO_206.getCode(),LogCode.API_INFO_206.getMessage());
    }
  }
}
