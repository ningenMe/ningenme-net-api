package ningenme.net.api.category.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.category.domain.entity.Genre;
import ningenme.net.api.category.infrastructure.mysql.dto.GenreMysqlDto;
import ningenme.net.api.category.infrastructure.mysql.mapper.GenreMysqlMapper;
import ningenme.net.api.util.domain.exception.SelectMysqlException;
import ningenme.net.api.category.domain.repository.GenreMysqlRepository;
import ningenme.net.api.category.domain.value.Label;
import ningenme.net.api.util.domain.value.LogCode;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Slf4j
public class GenreMysqlMysqlRepositoryImpl implements GenreMysqlRepository {

    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    @Cacheable("comproCategoryGenre")
    public List<Genre> get() {

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
    public Genre get(Label label) throws IllegalArgumentException {
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