package ningenme.net.api.category.domain.service;

import ningenme.net.api.category.domain.entity.Topic;

import java.util.List;

public interface TopicService {
    public List<Topic> get();
    public Topic get(String topicId);
    public Topic getWithTask(String topicId);
}