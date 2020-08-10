package ningenme.net.api.domain.repository;

import java.util.List;

import ningenme.net.api.domain.entity.Genre;

public interface GenreRepository {
    public List<Genre> get();
}