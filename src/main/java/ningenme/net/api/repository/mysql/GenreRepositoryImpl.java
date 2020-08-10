package ningenme.net.api.repository.mysql;

import java.util.List;
import java.util.stream.Collectors;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.Genre;
import ningenme.net.api.domain.repository.GenreRepository;
import ningenme.net.api.repository.dto.GenreDto;
import ningenme.net.api.repository.mysql.mapper.GenreMapper;

@Repository
@RequiredArgsConstructor
public class GenreRepositoryImpl implements GenreRepository {

    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<Genre> get() {
        List<GenreDto> genreDtoList = sqlSessionTemplate.getMapper(GenreMapper.class).select(null);
        return genreDtoList.stream().map(genreDto -> genreDto.convertGenre()).collect(Collectors.toList());
    }
}