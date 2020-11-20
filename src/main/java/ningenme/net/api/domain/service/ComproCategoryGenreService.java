package ningenme.net.api.domain.service;

import ningenme.net.api.domain.entity.ComproCategoryGenre;
import ningenme.net.api.domain.value.Label;

import java.util.List;

public interface ComproCategoryGenreService {
    public List<ComproCategoryGenre> get();
    public ComproCategoryGenre get(Label label);
    public ComproCategoryGenre getWithTopics(Label label);
    public List<ComproCategoryGenre> getWithTopic();
}