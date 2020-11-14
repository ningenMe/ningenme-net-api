package ningenme.net.api.domain.value;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(description = "ユニークタスクIDの値オブジェクト")
@Getter
public class TaskUniqueId {
  @JsonProperty("uniqueTaskId")
  @ApiModelProperty(value = "uniqueTaskId", example = "")
  @NonNull
  private final UUID value;

  public static TaskUniqueId of(String uniqueTaskId) throws NullPointerException,IllegalArgumentException {
    return new TaskUniqueId(UUID.fromString(uniqueTaskId));
  }
  public static TaskUniqueId of() {
    return new TaskUniqueId(UUID.randomUUID());
  }
}
