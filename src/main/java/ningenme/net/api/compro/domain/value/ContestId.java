package ningenme.net.api.compro.domain.value;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@ApiModel(description = "contest id")
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ContestId {
  private final static String CONTEST_SCREEN_NAME_SUFFIX = ".contest.atcoder.jp";
  private final String value;
  public static ContestId of(String contestId) {
    if(contestId.endsWith(CONTEST_SCREEN_NAME_SUFFIX)) {
      contestId = contestId.substring(0,contestId.length() - CONTEST_SCREEN_NAME_SUFFIX.length());
    }
    return new ContestId(contestId);
  }
}
