package ningenme.net.api.application.controller.comproTask.getOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproTask;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GetOneResponse {
  private final ComproTaskResponseDto comproTask;
  public static GetOneResponse of(ComproTask argComproTask) {
    return new GetOneResponse(ComproTaskResponseDto.of(argComproTask));
  }
}
