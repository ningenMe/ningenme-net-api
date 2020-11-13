package ningenme.net.api.domain.value;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(description = "カテゴリーの順序の値オブジェクト")
@Getter
public class CategoryOrder {
  @ApiModelProperty(value = "CategoryOrder", example = "100")
  @NonNull
  private final Integer value;
  public static CategoryOrder of(@NonNull Integer categoryOrder) throws NullPointerException,IllegalArgumentException {

    if(categoryOrder < 0) {
      throw new IllegalArgumentException("Illegal categoryOrder" + categoryOrder);
    }

    return new CategoryOrder(categoryOrder);
  }
}
