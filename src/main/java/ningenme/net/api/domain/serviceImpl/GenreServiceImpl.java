package ningenme.net.api.domain.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.Genre;
import ningenme.net.api.domain.repository.GenreRepository;
import ningenme.net.api.domain.service.GenreService;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    
    private final GenreRepository genreRepository;

    @Override
    public List<Genre> get() {
        return genreRepository.get();
    }
    @Override
    public Genre get(String label) {
        return genreRepository.get(label);
    }

}