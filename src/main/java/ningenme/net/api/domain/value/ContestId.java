package ningenme.net.api.domain.value;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@ApiModel(description = "contest id")
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ContestId {
  private final String value;
  public static ContestId of(String contestId) {
    return new ContestId(contestId);
  }
}
