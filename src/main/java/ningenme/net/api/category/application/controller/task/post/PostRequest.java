package ningenme.net.api.category.application.controller.task.post;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter
@RequiredArgsConstructor
@ApiModel(value = "ComproCategoryTaskPost")
public class PostRequest implements Serializable {
  @NotNull
  private final String url;
  private final String taskName;
  @Min(0)
  private final Integer estimation;
  @Min(0)
  private final Integer score;
  @NotEmpty
  @NotNull
  private final List<String> topicIdList;
}
