package ningenme.net.api.domain.service;

import ningenme.net.api.domain.entity.ComproCategoryGenre;
import ningenme.net.api.domain.entity.ComproCategoryTopic;
import ningenme.net.api.domain.value.Label;

import java.util.List;

public interface ComproCategoryTopicService {
    public List<ComproCategoryTopic> get();
    public ComproCategoryTopic get(Integer topicId);
}