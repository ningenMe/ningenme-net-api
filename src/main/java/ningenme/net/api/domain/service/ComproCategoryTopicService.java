package ningenme.net.api.domain.service;

import ningenme.net.api.domain.entity.ComproCategoryTopic;

import java.util.List;

public interface ComproCategoryTopicService {
    public List<ComproCategoryTopic> get();
    public ComproCategoryTopic get(String topicId);
    public ComproCategoryTopic getWithTask(String topicId);
}