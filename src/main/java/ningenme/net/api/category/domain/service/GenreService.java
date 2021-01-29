package ningenme.net.api.category.domain.service;

import ningenme.net.api.category.domain.entity.Genre;
import ningenme.net.api.category.domain.value.Label;

import java.util.List;

public interface GenreService {
    public List<Genre> get();
    public Genre get(Label label);
    public Genre getWithTopics(Label label);
    public List<Genre> getWithTopic();
}