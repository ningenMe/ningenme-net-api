package ningenme.net.api.category.application.controller.task.getOne;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Task;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTaskGetOne")
public class GetOneResponse {
  private final ComproCategoryTaskResponseDto comproCategoryTask;
  public static GetOneResponse of(Task argTask) {
    return new GetOneResponse(ComproCategoryTaskResponseDto.of(argTask));
  }
}
