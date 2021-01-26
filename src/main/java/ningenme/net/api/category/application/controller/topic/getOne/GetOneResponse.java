package ningenme.net.api.category.application.controller.topic.getOne;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTopic;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTopicGetOne")
public class GetOneResponse {
  private final ComproCategoryTopicResponseDto comproCategoryTopic;
  public static GetOneResponse of(ComproCategoryTopic argComproCategoryTopic) {
    return new GetOneResponse(ComproCategoryTopicResponseDto.of(argComproCategoryTopic));
  }
}
