package ningenme.net.api.category.application.controller.topic.getList;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Topic;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTopicGetList")
public class GetListResponse {
  private final List<ComproCategoryTopicResponseDto> comproCategoryTopicList;
  public static GetListResponse of(@NonNull List<Topic> argTopicList) {
    return new GetListResponse(
            argTopicList
                    .stream()
                    .map(
                            comproCategoryTopic -> ComproCategoryTopicResponseDto.of(comproCategoryTopic)
                    )
                    .collect(Collectors.toList())
    );
  }
}
