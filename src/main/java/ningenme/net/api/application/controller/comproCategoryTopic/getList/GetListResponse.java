package ningenme.net.api.application.controller.comproCategoryTopic.getList;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTopic;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTopicGetList")
public class GetListResponse {
  private final List<ComproCategoryTopicResponseDto> comproCategoryTopicList;
  public static GetListResponse of(@NonNull List<ComproCategoryTopic> argComproCategoryTopicList) {
    return new GetListResponse(
            argComproCategoryTopicList
                    .stream()
                    .map(
                            comproCategoryTopic -> ComproCategoryTopicResponseDto.of(comproCategoryTopic)
                    )
                    .collect(Collectors.toList())
    );
  }
}
