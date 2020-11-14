package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;
import ningenme.net.api.domain.entity.ComproCategoryTopic;
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
  public List<ComproCategoryGenre> get() { return comproCategoryGenreRepository.get(); }

  @Override
  public ComproCategoryGenre get(Label label) { return comproCategoryGenreRepository.get(label); }

  @Override
  public ComproCategoryGenre getWithTopics(Label label) {
    ComproCategoryGenre       comproCategoryGenre     = comproCategoryGenreRepository.get(label);
    List<ComproCategoryTopic> comproCategoryTopicList = comproCategoryTopicRepository.get();
    comproCategoryGenre.setComproCategoryTopicList(comproCategoryTopicList);
    for (ComproCategoryTopic comproCategoryTopic: comproCategoryGenre.getComproCategoryTopicList()) {
      comproCategoryTopic.setComproCategoryTaskList(comproCategoryTaskRepository.getListByTopicId(comproCategoryTopic.getTopicId()));
    }
    return comproCategoryGenre;
  }
}