package ningenme.net.api.category.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Genre;
import ningenme.net.api.category.domain.entity.Topic;
import ningenme.net.api.category.domain.repository.GenreMysqlRepository;
import ningenme.net.api.category.domain.repository.TaskMysqlRepository;
import ningenme.net.api.category.domain.repository.TopicMysqlRepository;
import ningenme.net.api.category.domain.service.GenreService;
import ningenme.net.api.domain.value.Label;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

  private final GenreMysqlRepository genreMysqlRepository;
  private final TopicMysqlRepository topicMysqlRepository;
  private final TaskMysqlRepository taskMysqlRepository;

  @Override
  public List<Genre> get() { return genreMysqlRepository.get(); }

  @Override
  public Genre get(Label label) { return genreMysqlRepository.get(label); }

  @Override
  public Genre getWithTopics(Label label) {
    Genre genre = genreMysqlRepository.get(label);
    List<Topic> topicList = topicMysqlRepository.get();
    genre.setTopicList(topicList);
    for (Topic topic : genre.getTopicList()) {
      topic.setTaskList(taskMysqlRepository.getListByTopicId(topic.getTopicId()));
    }
    return genre;
  }

  @Override
  public List<Genre> getWithTopic() {
    List<Genre> genreList = genreMysqlRepository.get();
    List<Topic> topicList = topicMysqlRepository.get();
    for (Genre genre : genreList) {
      genre.setTopicList(topicList);
    }
    return genreList;
  }
}