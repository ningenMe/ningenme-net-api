package ningenme.net.api.category.application.controller.comproCategoryTopic.getOneWithTask;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTopic;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTopicGetOneWithTask")
public class GetOneWithTaskResponse {
  private final ComproCategoryTopicResponseDto comproCategoryTopic;
  public static GetOneWithTaskResponse of(ComproCategoryTopic argComproCategoryTopic) {
    return new GetOneWithTaskResponse(ComproCategoryTopicResponseDto.of(argComproCategoryTopic));
  }
}
