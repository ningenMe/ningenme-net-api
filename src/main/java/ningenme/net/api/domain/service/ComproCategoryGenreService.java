package ningenme.net.api.domain.service;

import ningenme.net.api.category.domain.entity.Genre;
import ningenme.net.api.domain.value.Label;

import java.util.List;

public interface ComproCategoryGenreService {
    public List<Genre> get();
    public Genre get(Label label);
    public Genre getWithTopics(Label label);
    public List<Genre> getWithTopic();
}