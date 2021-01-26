package ningenme.net.api.category.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.category.domain.entity.Topic;
import ningenme.net.api.category.infrastructure.mysql.dto.TopicMysqlDto;
import ningenme.net.api.category.infrastructure.mysql.mapper.TopicMysqlMapper;
import ningenme.net.api.util.domain.exception.SelectMysqlException;
import ningenme.net.api.category.domain.repository.TopicMysqlRepository;
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
public class TopicMysqlMysqlRepositoryImpl implements TopicMysqlRepository {

    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    @Cacheable("comproCategoryTopic")
    public List<Topic> get() {

        try {
            List<TopicMysqlDto> topicMysqlDtoList
                    = sqlSessionTemplate
                    .getMapper(TopicMysqlMapper.class)
                    .select(null);

            log.info("code={},message={}", LogCode.API_INFO_205.getCode(),LogCode.API_INFO_205.getMessage());
            return topicMysqlDtoList
                    .stream()
                    .map(topicMysqlDto -> topicMysqlDto.convertComproCategoryTopic())
                    .collect(Collectors.toList());
        }
        catch (Exception ex) {
            throw new SelectMysqlException(ex);
        }
    }

    @Override
    public Topic get(String topicId) throws IllegalArgumentException {
        List<TopicMysqlDto> topicMysqlDtoList = new ArrayList<>();
        try {
            topicMysqlDtoList
                    = sqlSessionTemplate
                    .getMapper(TopicMysqlMapper.class)
                    .select(topicId);
        }
        catch (Exception ex) {
            throw new SelectMysqlException(ex);
        }

        if (topicMysqlDtoList.isEmpty() ) {
            throw new IllegalArgumentException("no topic: " + topicId);
        }

        return topicMysqlDtoList.get(0).convertComproCategoryTopic();
    }
}