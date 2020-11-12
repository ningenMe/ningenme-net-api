package ningenme.net.api.domain.value;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(description = "点数の値オブジェクト")
@Getter
public class TaskScore {

  @ApiModelProperty(value = "TaskScore", example = "400")
  @NonNull
  private final Integer value;

  public static TaskScore of(@NonNull Integer taskScore) throws NullPointerException,IllegalArgumentException {

    if(taskScore < 0) {
      throw new IllegalArgumentException("Illegal taskScore" + taskScore);
    }

    return new TaskScore(taskScore);
  }
}


