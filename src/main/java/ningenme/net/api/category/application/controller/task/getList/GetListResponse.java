package ningenme.net.api.category.application.controller.task.getList;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.category.domain.entity.Task;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTaskGetList")
public class GetListResponse {
  private final List<ComproCategoryTaskResponseDto> comproCategoryTaskList;
  public static GetListResponse of(@NonNull List<Task> argTaskList) {
    return new GetListResponse(
            argTaskList.stream()
                    .map(comproCategoryTask -> ComproCategoryTaskResponseDto.of(comproCategoryTask))
                    .collect(Collectors.toList())
    );
  }
}
