package ningenme.net.api.domain.repository;

import ningenme.net.api.category.domain.entity.Genre;
import ningenme.net.api.domain.value.Label;

import java.util.List;

public interface ComproCategoryGenreRepository {
  public List<Genre> get();
  public Genre get(Label label);
}
