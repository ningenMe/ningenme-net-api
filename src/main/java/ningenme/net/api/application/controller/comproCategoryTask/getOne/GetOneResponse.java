package ningenme.net.api.application.controller.comproCategoryTask.getOne;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTask;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTaskGetOne")
public class GetOneResponse {
  private final ComproCategoryTaskResponseDto comproCategoryTask;
  public static GetOneResponse of(ComproCategoryTask argComproCategoryTask) {
    return new GetOneResponse(ComproCategoryTaskResponseDto.of(argComproCategoryTask));
  }
}
