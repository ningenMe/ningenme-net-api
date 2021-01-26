package ningenme.net.api.category.application.controller.topic.getOneWithTask;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Topic;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTopicGetOneWithTask")
public class GetOneWithTaskResponse {
  private final ComproCategoryTopicResponseDto comproCategoryTopic;
  public static GetOneWithTaskResponse of(Topic argTopic) {
    return new GetOneWithTaskResponse(ComproCategoryTopicResponseDto.of(argTopic));
  }
}
