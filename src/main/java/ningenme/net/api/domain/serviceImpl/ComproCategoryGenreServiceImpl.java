package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Genre;
import ningenme.net.api.category.domain.entity.Topic;
import ningenme.net.api.domain.repository.ComproCategoryGenreRepository;
import ningenme.net.api.domain.repository.ComproCategoryTaskRepository;
import ningenme.net.api.domain.repository.ComproCategoryTopicRepository;
import ningenme.net.api.domain.service.ComproCategoryGenreService;
import ningenme.net.api.domain.value.Label;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComproCategoryGenreServiceImpl implements ComproCategoryGenreService {

  private final ComproCategoryGenreRepository comproCategoryGenreRepository;
  private final ComproCategoryTopicRepository comproCategoryTopicRepository;
  private final ComproCategoryTaskRepository  comproCategoryTaskRepository;

  @Override
  public List<Genre> get() { return comproCategoryGenreRepository.get(); }

  @Override
  public Genre get(Label label) { return comproCategoryGenreRepository.get(label); }

  @Override
  public Genre getWithTopics(Label label) {
    Genre genre = comproCategoryGenreRepository.get(label);
    List<Topic> topicList = comproCategoryTopicRepository.get();
    genre.setTopicList(topicList);
    for (Topic topic : genre.getTopicList()) {
      topic.setTaskList(comproCategoryTaskRepository.getListByTopicId(topic.getTopicId()));
    }
    return genre;
  }

  @Override
  public List<Genre> getWithTopic() {
    List<Genre> genreList = comproCategoryGenreRepository.get();
    List<Topic> topicList = comproCategoryTopicRepository.get();
    for (Genre genre : genreList) {
      genre.setTopicList(topicList);
    }
    return genreList;
  }
}