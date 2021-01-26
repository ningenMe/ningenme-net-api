package ningenme.net.api.category.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.category.infrastructure.mysql.dto.GenreMysqlDto;
import ningenme.net.api.category.infrastructure.mysql.mapper.GenreMysqlMapper;
import ningenme.net.api.domain.entity.ComproCategoryGenre;
import ningenme.net.api.domain.exception.SelectMysqlException;
import ningenme.net.api.domain.repository.ComproCategoryGenreRepository;
import ningenme.net.api.domain.value.Label;
import ningenme.net.api.domain.value.LogCode;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Slf4j
public class GenreMysqlRepositoryImpl implements ComproCategoryGenreRepository {

    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    @Cacheable("comproCategoryGenre")
    public List<ComproCategoryGenre> get() {

        try {
            List<GenreMysqlDto> comproCategoryGenreList = sqlSessionTemplate.getMapper(GenreMysqlMapper.class).select(null);

            log.info("code={},message={}", LogCode.API_INFO_204.getCode(),LogCode.API_INFO_204.getMessage());
            return comproCategoryGenreList
                    .stream()
                    .map(genreMysqlDto -> genreMysqlDto.convertComproCategoryGenre())
                    .collect(Collectors.toList());
        }
        catch (Exception ex) {
            throw new SelectMysqlException(ex);
        }
    }

    @Override
    public ComproCategoryGenre get(Label label) throws IllegalArgumentException {
        List<GenreMysqlDto> comproCategoryGenreList = new ArrayList<>();
        try {
            comproCategoryGenreList = sqlSessionTemplate.getMapper(GenreMysqlMapper.class).select(label.getValue());
        }
        catch (Exception ex) {
            throw new SelectMysqlException(ex);
        }

        if (comproCategoryGenreList.isEmpty() ) {
            throw new IllegalArgumentException("no genre: " + label.getValue());
        }

        return comproCategoryGenreList.get(0).convertComproCategoryGenre();
    }
}