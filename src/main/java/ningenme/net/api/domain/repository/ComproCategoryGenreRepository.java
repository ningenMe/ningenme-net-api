package ningenme.net.api.domain.repository;

import ningenme.net.api.domain.entity.ComproCategoryGenre;
import ningenme.net.api.domain.value.Label;

import java.util.List;

public interface ComproCategoryGenreRepository {
  public List<ComproCategoryGenre> get();
  public ComproCategoryGenre get(Label label);
}
