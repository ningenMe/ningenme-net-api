package ningenme.net.api.category.application.controller.topic.getOne;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Topic;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTopicGetOne")
public class GetOneResponse {
  private final ComproCategoryTopicResponseDto comproCategoryTopic;
  public static GetOneResponse of(Topic argTopic) {
    return new GetOneResponse(ComproCategoryTopicResponseDto.of(argTopic));
  }
}
