package ningenme.net.api.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.ComproCategoryTopic;
import ningenme.net.api.domain.exception.SelectMysqlException;
import ningenme.net.api.domain.repository.ComproCategoryTopicRepository;
import ningenme.net.api.domain.value.LogCode;
import ningenme.net.api.infrastructure.dto.ComproCategoryTopicDto;
import ningenme.net.api.infrastructure.mysql.mapper.ComproCategoryTopicMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ComproCategoryTopicRepositoryImpl implements ComproCategoryTopicRepository {

    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    @Cacheable("comproCategoryTopic")
    public List<ComproCategoryTopic> get() {

        try {
            List<ComproCategoryTopicDto> comproCategoryTopicDtoList
                    = sqlSessionTemplate
                    .getMapper(ComproCategoryTopicMapper.class)
                    .select(null);

            log.info("code={},message={}", LogCode.API_INFO_205.getCode(),LogCode.API_INFO_205.getMessage());
            return comproCategoryTopicDtoList
                    .stream()
                    .map(comproCategoryTopicDto -> comproCategoryTopicDto.convertComproCategoryTopic())
                    .collect(Collectors.toList());
        }
        catch (Exception ex) {
            throw new SelectMysqlException(ex);
        }
    }

    @Override
    public ComproCategoryTopic get(String topicId) throws IllegalArgumentException {
        List<ComproCategoryTopicDto> comproCategoryTopicDtoList = new ArrayList<>();
        try {
            comproCategoryTopicDtoList
                    = sqlSessionTemplate
                    .getMapper(ComproCategoryTopicMapper.class)
                    .select(topicId);
        }
        catch (Exception ex) {
            throw new SelectMysqlException(ex);
        }

        if (comproCategoryTopicDtoList.isEmpty() ) {
            throw new IllegalArgumentException("no topic: " + topicId);
        }

        return comproCategoryTopicDtoList.get(0).convertComproCategoryTopic();
    }
}