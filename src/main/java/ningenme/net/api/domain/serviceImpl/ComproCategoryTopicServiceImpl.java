package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Genre;
import ningenme.net.api.category.domain.entity.Task;
import ningenme.net.api.category.domain.entity.Topic;
import ningenme.net.api.category.domain.repository.GenreMysqlRepository;
import ningenme.net.api.category.domain.repository.TaskMysqlRepository;
import ningenme.net.api.category.domain.repository.TopicMysqlRepository;
import ningenme.net.api.domain.service.ComproCategoryTopicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComproCategoryTopicServiceImpl implements ComproCategoryTopicService {

  private final TopicMysqlRepository topicMysqlRepository;
  private final GenreMysqlRepository genreMysqlRepository;
  private final TaskMysqlRepository taskMysqlRepository;

  @Override
  public List<Topic> get() {
    List<Topic> topicList = topicMysqlRepository.get();
    List<Genre> genreList = genreMysqlRepository.get();
    for (Topic topic : topicList) {
      topic.setGenreName(genreList);
    }
    return topicList;
  }

  @Override
  public Topic get(String topicId) {
    Topic topic = topicMysqlRepository.get(topicId);
    List<Genre> genreList = genreMysqlRepository.get();
    topic.setGenreName(genreList);
    return topic;
  }

  @Override
  public Topic getWithTask(String topicId) {
    Topic topic = topicMysqlRepository.get(topicId);
    List<Genre> genreList = genreMysqlRepository.get();
    List<Task> taskList = taskMysqlRepository.getListByTopicId(topicId);
    topic.setGenreName(genreList);
    topic.setTaskList(taskList);
    return topic;
  }
}