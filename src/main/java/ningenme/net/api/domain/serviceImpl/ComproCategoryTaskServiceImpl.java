package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTask;
import ningenme.net.api.domain.entity.ComproCategoryTopic;
import ningenme.net.api.domain.repository.ComproCategoryTaskRepository;
import ningenme.net.api.domain.repository.ComproCategoryTopicRepository;
import ningenme.net.api.domain.service.ComproCategoryTaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComproCategoryTaskServiceImpl implements ComproCategoryTaskService {
  private final ComproCategoryTaskRepository  comproCategoryTaskRepository;
  private final ComproCategoryTopicRepository comproCategoryTopicRepository;
  @Override
  public List<ComproCategoryTask> get(Integer offset) {
    List<ComproCategoryTask>  comproCategoryTaskList  = comproCategoryTaskRepository.get(offset);
    List<ComproCategoryTopic> comproCategoryTopicList = comproCategoryTopicRepository.get();
    for (ComproCategoryTask comproCategoryTask:comproCategoryTaskList) {
      comproCategoryTask.setTopicList(comproCategoryTopicList);
    }
    return comproCategoryTaskList;
  }
}