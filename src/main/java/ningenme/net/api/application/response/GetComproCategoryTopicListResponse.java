package ningenme.net.api.application.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;
import ningenme.net.api.domain.entity.ComproCategoryTopic;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GetComproCategoryTopicListResponse {
  private final List<ComproCategoryTopic> comproCategoryTopicList;
  public static GetComproCategoryTopicListResponse of(@NonNull List<ComproCategoryTopic> comproCategoryTopicList) {
    return new GetComproCategoryTopicListResponse(comproCategoryTopicList);
  }
}
