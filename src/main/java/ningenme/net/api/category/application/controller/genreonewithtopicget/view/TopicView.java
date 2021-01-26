package ningenme.net.api.category.application.controller.genreonewithtopicget.view;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTopic;

import java.util.List;
import java.util.stream.Collectors;

/**
 * レスポンス時のDTO, プリミティブ型のメンバのみで構成する
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetOneWithTopicComproCategoryTopicResponseDto")
public class TopicView {
  private final String topicId;
  private final String topicName;
  private final Integer topicOrder;
  private final List<TaskView> tasks;
  public static TopicView of(ComproCategoryTopic comproCategoryTopic) {
    return new TopicView(
            comproCategoryTopic.getTopicId(),
            comproCategoryTopic.getTopicName(),
            comproCategoryTopic.getTopicOrder().getValue(),
            comproCategoryTopic.getComproCategoryTaskList()
                    .stream()
                    .map(comproCategoryTask -> TaskView.of(comproCategoryTask))
                    .collect(Collectors.toList())
    );
  }
}
