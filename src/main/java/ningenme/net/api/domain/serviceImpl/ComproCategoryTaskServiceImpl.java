package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.category.domain.entity.Task;
import ningenme.net.api.category.domain.entity.Topic;
import ningenme.net.api.domain.exception.ComproCategoryTaskUrlDuplicatedException;
import ningenme.net.api.domain.repository.ComproCategoryTaskRepository;
import ningenme.net.api.domain.repository.ComproCategoryTopicRepository;
import ningenme.net.api.domain.repository.ComproCategoryTopicTaskRepository;
import ningenme.net.api.domain.service.ComproCategoryTaskService;
import ningenme.net.api.compro.domain.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComproCategoryTaskServiceImpl implements ComproCategoryTaskService {
  private final ComproCategoryTaskRepository      comproCategoryTaskRepository;
  private final ComproCategoryTopicRepository     comproCategoryTopicRepository;
  private final ComproCategoryTopicTaskRepository comproCategoryTopicTaskRepository;
  private final TaskService taskService;
  @Override
  public List<Task> getList(Integer offset) {
    List<Task> taskList = comproCategoryTaskRepository.getList(offset);
    List<Topic> topicList = comproCategoryTopicRepository.get();
    for (Task task : taskList) {
      task.setTopicList(topicList);
    }
    return taskList;
  }
  @Override
  public Task getOne(String taskId) {
    Task task = comproCategoryTaskRepository.getOne(taskId);
    List<Topic> topicList = comproCategoryTopicRepository.get();
    task.setTopicList(topicList);
    return task;
  }
  @Override
  public Integer getCount() {
    return comproCategoryTaskRepository.getCount();
  }

  @Override
  public void post(Task comproCategoryTask) {

    Integer alreadyPostedCount = comproCategoryTaskRepository.getCountByUrl(comproCategoryTask.getUrl());
    //urlで既出判定を行う
    if(alreadyPostedCount > 0) {
      throw new ComproCategoryTaskUrlDuplicatedException(new Exception());
    }

    //名前がデフォルトならデータ取得
    if(Objects.equals(comproCategoryTask.getTaskName(),".")) {
      ningenme.net.api.compro.domain.entity.Task task = taskService.get(comproCategoryTask.getUrl());

      if (Objects.nonNull(task)) {
        comproCategoryTask = Task.of(
                comproCategoryTask.getTaskId(),
                task.getTaskName(),
                task.getUrl(),
                task.getTaskScore(),
                comproCategoryTask.getEstimation(),
                comproCategoryTask.getTopicIdList(),
                comproCategoryTask.getCreatedTime()
        );
      }

    }

    log.info("taskId={}, url={} , name={}",comproCategoryTask.getTaskId(), comproCategoryTask.getUrl().getValue(),comproCategoryTask.getTaskName());
    comproCategoryTaskRepository.post(comproCategoryTask);
    comproCategoryTopicTaskRepository.postList(comproCategoryTask.getComproCategoryTopicTaskList());
  }

  @Override
  public void put(Task task) {

    //未投稿データの場合ここでexceptionを吐く
    Task alreadyPostedTask = comproCategoryTaskRepository.getOne(task.getTaskId());

    log.info("taskId={}, url={} , name={}", task.getTaskId(), task.getUrl().getValue(), task.getTaskName());
    comproCategoryTaskRepository.put(task);
    comproCategoryTopicTaskRepository.deleteByTaskId(task.getTaskId());
    comproCategoryTopicTaskRepository.postList(task.getComproCategoryTopicTaskList());
  }

}