package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;
import ningenme.net.api.domain.entity.ComproCategoryTopic;
import ningenme.net.api.domain.repository.ComproCategoryGenreRepository;
import ningenme.net.api.domain.repository.ComproCategoryTopicRepository;
import ningenme.net.api.domain.service.ComproCategoryGenreService;
import ningenme.net.api.domain.service.ComproCategoryTopicService;
import ningenme.net.api.domain.value.Label;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComproCategoryTopicServiceImpl implements ComproCategoryTopicService {

  private final ComproCategoryTopicRepository comproCategoryTopicRepository;
  private final ComproCategoryGenreRepository comproCategoryGenreRepository;

  @Override
  public List<ComproCategoryTopic> get() {
    List<ComproCategoryTopic> comproCategoryTopicList = comproCategoryTopicRepository.get();
    List<ComproCategoryGenre> comproCategoryGenreList = comproCategoryGenreRepository.get();
    for (ComproCategoryTopic comproCategoryTopic:comproCategoryTopicList) {
      comproCategoryTopic.setGenreName(comproCategoryGenreList);
    }
    return comproCategoryTopicList;
  }

  @Override
  public ComproCategoryTopic get(Integer topicId) {
    ComproCategoryTopic comproCategoryTopic = comproCategoryTopicRepository.get(topicId);
    List<ComproCategoryGenre> comproCategoryGenreList = comproCategoryGenreRepository.get();
    comproCategoryTopic.setGenreName(comproCategoryGenreList);
    return comproCategoryTopic;
  }
}