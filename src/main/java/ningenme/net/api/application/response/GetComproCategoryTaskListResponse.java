package ningenme.net.api.application.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTask;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GetComproCategoryTaskListResponse {
  private final List<ComproCategoryTask> comproCategoryTaskList;
  private final Integer offset;
  private final Integer nextOffset;
  public static GetComproCategoryTaskListResponse of(@NonNull List<ComproCategoryTask> comproCategoryTaskList, Integer offset, Integer nextOffset) {
    return new GetComproCategoryTaskListResponse(comproCategoryTaskList,offset,nextOffset);
  }
}
