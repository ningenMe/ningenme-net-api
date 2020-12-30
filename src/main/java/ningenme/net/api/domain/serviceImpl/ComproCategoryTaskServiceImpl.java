package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.ComproCategoryTask;
import ningenme.net.api.domain.entity.ComproCategoryTopic;
import ningenme.net.api.domain.entity.ComproTask;
import ningenme.net.api.domain.exception.ComproCategoryTaskUrlDuplicatedException;
import ningenme.net.api.domain.repository.ComproCategoryTaskRepository;
import ningenme.net.api.domain.repository.ComproCategoryTopicRepository;
import ningenme.net.api.domain.repository.ComproCategoryTopicTaskRepository;
import ningenme.net.api.domain.service.ComproCategoryTaskService;
import ningenme.net.api.domain.service.ComproTaskService;
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
  private final ComproTaskService                 comproTaskService;
  @Override
  public List<ComproCategoryTask> getList(Integer offset) {
    List<ComproCategoryTask>  comproCategoryTaskList  = comproCategoryTaskRepository.getList(offset);
    List<ComproCategoryTopic> comproCategoryTopicList = comproCategoryTopicRepository.get();
    for (ComproCategoryTask comproCategoryTask:comproCategoryTaskList) {
      comproCategoryTask.setTopicList(comproCategoryTopicList);
    }
    return comproCategoryTaskList;
  }
  @Override
  public ComproCategoryTask getOne(String taskId) {
    ComproCategoryTask comproCategoryTask = comproCategoryTaskRepository.getOne(taskId);
    List<ComproCategoryTopic> comproCategoryTopicList = comproCategoryTopicRepository.get();
    comproCategoryTask.setTopicList(comproCategoryTopicList);
    return comproCategoryTask;
  }
  @Override
  public Integer getCount() {
    return comproCategoryTaskRepository.getCount();
  }

  @Override
  public void post(ComproCategoryTask comproCategoryTask) {

    Integer alreadyPostedCount = comproCategoryTaskRepository.getCountByUrl(comproCategoryTask.getUrl());
    //urlで既出判定を行う
    if(alreadyPostedCount > 0) {
      throw new ComproCategoryTaskUrlDuplicatedException(new Exception());
    }

    //名前がデフォルトならデータ取得
    if(Objects.equals(comproCategoryTask.getTaskName(),".")) {
      ComproTask comproTask = comproTaskService.get(comproCategoryTask.getUrl());

      if (Objects.nonNull(comproTask)) {
        comproCategoryTask = ComproCategoryTask.of(
                comproCategoryTask.getTaskId(),
                comproTask.getTaskName(),
                comproTask.getUrl(),
                comproTask.getTaskScore(),
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
  public void put(ComproCategoryTask comproCategoryTask) {

    //未投稿データの場合ここでexceptionを吐く
    ComproCategoryTask alreadyPostedComproCategoryTask = comproCategoryTaskRepository.getOne(comproCategoryTask.getTaskId());

    log.info("taskId={}, url={} , name={}",comproCategoryTask.getTaskId(), comproCategoryTask.getUrl().getValue(),comproCategoryTask.getTaskName());
    comproCategoryTaskRepository.put(comproCategoryTask);
    comproCategoryTopicTaskRepository.deleteByTaskId(comproCategoryTask.getTaskId());
    comproCategoryTopicTaskRepository.postList(comproCategoryTask.getComproCategoryTopicTaskList());
  }

}