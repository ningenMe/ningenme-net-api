package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;
import ningenme.net.api.domain.repository.ComproCategoryGenreRepository;
import ningenme.net.api.domain.service.ComproCategoryGenreService;
import ningenme.net.api.domain.value.Label;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComproCategoryGenreServiceImpl implements ComproCategoryGenreService {

  private final ComproCategoryGenreRepository comproCategoryGenreRepository;

  @Override
  public List<ComproCategoryGenre> get() {
    return comproCategoryGenreRepository.get();
  }

  @Override
  public ComproCategoryGenre get(Label label) { return comproCategoryGenreRepository.get(label);
  }
}