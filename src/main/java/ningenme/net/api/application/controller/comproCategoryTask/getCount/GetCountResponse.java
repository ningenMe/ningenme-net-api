package ningenme.net.api.application.controller.comproCategoryTask.getCount;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTaskGetCount")
public class GetCountResponse {
  private final Integer count;
  public static GetCountResponse of(@NonNull Integer count) {
    return new GetCountResponse(count);
  }
}
