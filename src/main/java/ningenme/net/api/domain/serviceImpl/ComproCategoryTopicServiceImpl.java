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

  @Override
  public List<ComproCategoryTopic> get() {
    return comproCategoryTopicRepository.get();
  }

  @Override
  public ComproCategoryTopic get(Integer topicId) { return comproCategoryTopicRepository.get(topicId);
  }
}