package ningenme.net.api.application.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTask;
import ningenme.net.api.domain.entity.ComproCategoryTopic;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GetComproCategoryTaskOneResponse {
  private final ComproCategoryTask comproCategoryTask;
  public static GetComproCategoryTaskOneResponse of(@NonNull ComproCategoryTask comproCategoryTask) {
    return new GetComproCategoryTaskOneResponse(comproCategoryTask);
  }
}
