package ningenme.net.api.application.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTask;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GetComproCategoryTaskResponse {
  private final List<ComproCategoryTask> comproCategoryTaskList;
  private final Integer offset;
  private final Integer nextOffset;
  public static GetComproCategoryTaskResponse of(List<ComproCategoryTask> comproCategoryTaskList, Integer offset, Integer nextOffset) {
    return new GetComproCategoryTaskResponse(comproCategoryTaskList,offset,nextOffset);
  }
}
