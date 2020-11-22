package ningenme.net.api.infrastructure.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.AtcoderUser;
import ningenme.net.api.domain.value.AtcoderId;

@Getter
@RequiredArgsConstructor
public class AtcoderUserMysqlDto {
  private final String atcoderId;
  public static AtcoderUserMysqlDto of(AtcoderUser atcoderUser) {
    return new AtcoderUserMysqlDto(atcoderUser.getAtcoderId().getValue());
  }
  public AtcoderUser convertAtcoderUser() {
    return AtcoderUser.of(
            AtcoderId.of(atcoderId)
    );
  }
}
