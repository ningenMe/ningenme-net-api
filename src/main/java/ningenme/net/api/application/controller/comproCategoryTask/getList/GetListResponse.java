package ningenme.net.api.application.controller.comproCategoryTask.getList;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTask;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTaskGetList")
public class GetListResponse {
  private final List<ComproCategoryTaskResponseDto> comproCategoryTaskList;
  public static GetListResponse of(@NonNull List<ComproCategoryTask> argComproCategoryTaskList) {
    return new GetListResponse(
            argComproCategoryTaskList.stream()
                    .map(comproCategoryTask -> ComproCategoryTaskResponseDto.of(comproCategoryTask))
                    .collect(Collectors.toList())
    );
  }
}
