package ningenme.net.api.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.ComproCategoryTopicTask;
import ningenme.net.api.domain.repository.ComproCategoryTopicTaskRepository;
import ningenme.net.api.domain.value.LogCode;
import ningenme.net.api.infrastructure.mysql.dto.ComproCategoryTopicTaskDto;
import ningenme.net.api.infrastructure.mysql.mapper.ComproCategoryTopicTaskMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ComproCategoryTopicTaskRepositoryImpl implements ComproCategoryTopicTaskRepository {
  private final SqlSessionTemplate sqlSessionTemplate;

  @Override
  public void postList(List<ComproCategoryTopicTask> comproCategoryTopicTaskList) {
    for (ComproCategoryTopicTask comproCategoryTopicTask: comproCategoryTopicTaskList) {
      try {
        sqlSessionTemplate.getMapper(ComproCategoryTopicTaskMapper.class).insert(
                ComproCategoryTopicTaskDto
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
      sqlSessionTemplate.getMapper(ComproCategoryTopicTaskMapper.class).deleteByTaskId(taskId);
    }
    catch (Exception ex) {
      log.info("code={}, message={}", LogCode.API_INFO_206.getCode(),LogCode.API_INFO_206.getMessage());
    }
  }
}
