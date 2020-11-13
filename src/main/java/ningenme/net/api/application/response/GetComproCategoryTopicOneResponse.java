package ningenme.net.api.application.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;
import ningenme.net.api.domain.entity.ComproCategoryTopic;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GetComproCategoryTopicOneResponse {
  private final ComproCategoryTopic comproCategoryTopic;
  public static GetComproCategoryTopicOneResponse of(@NonNull ComproCategoryTopic comproCategoryTopic) {
    return new GetComproCategoryTopicOneResponse(comproCategoryTopic);
  }
}
