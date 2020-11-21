package ningenme.net.api.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.AtcoderId;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AtcoderUser {
  private final AtcoderId atcoderId;
  public static AtcoderUser of(AtcoderId atcoderId){
    return new AtcoderUser(atcoderId);
  }
}
