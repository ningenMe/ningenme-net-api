package ningenme.net.api.category.domain.repository;

import ningenme.net.api.category.domain.entity.Genre;
import ningenme.net.api.category.domain.value.Label;

import java.util.List;

public interface GenreMysqlRepository {
  public List<Genre> get();
  public Genre get(Label label);
}
