package ningenme.net.api.infrastructure.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.AtcoderUser;

@Getter
@RequiredArgsConstructor
public class AtcoderUserMysqlDto {
  private final String atcoderId;
  public static AtcoderUserMysqlDto of(AtcoderUser atcoderUser) {
    return new AtcoderUserMysqlDto(atcoderUser.getAtcoderId().getValue());
  }
}