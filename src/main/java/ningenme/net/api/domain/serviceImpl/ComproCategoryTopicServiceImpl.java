package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Genre;
import ningenme.net.api.category.domain.entity.Task;
import ningenme.net.api.category.domain.entity.Topic;
import ningenme.net.api.domain.repository.ComproCategoryGenreRepository;
import ningenme.net.api.domain.repository.ComproCategoryTaskRepository;
import ningenme.net.api.domain.repository.ComproCategoryTopicRepository;
import ningenme.net.api.domain.service.ComproCategoryTopicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComproCategoryTopicServiceImpl implements ComproCategoryTopicService {

  private final ComproCategoryTopicRepository comproCategoryTopicRepository;
  private final ComproCategoryGenreRepository comproCategoryGenreRepository;
  private final ComproCategoryTaskRepository  comproCategoryTaskRepository;

  @Override
  public List<Topic> get() {
    List<Topic> topicList = comproCategoryTopicRepository.get();
    List<Genre> genreList = comproCategoryGenreRepository.get();
    for (Topic topic : topicList) {
      topic.setGenreName(genreList);
    }
    return topicList;
  }

  @Override
  public Topic get(String topicId) {
    Topic topic = comproCategoryTopicRepository.get(topicId);
    List<Genre> genreList = comproCategoryGenreRepository.get();
    topic.setGenreName(genreList);
    return topic;
  }

  @Override
  public Topic getWithTask(String topicId) {
    Topic topic = comproCategoryTopicRepository.get(topicId);
    List<Genre> genreList = comproCategoryGenreRepository.get();
    List<Task> taskList = comproCategoryTaskRepository.getListByTopicId(topicId);
    topic.setGenreName(genreList);
    topic.setTaskList(taskList);
    return topic;
  }
}