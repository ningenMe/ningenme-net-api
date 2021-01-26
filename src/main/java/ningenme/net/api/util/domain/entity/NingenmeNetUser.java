package ningenme.net.api.util.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.Email;
import ningenme.net.api.domain.value.Password;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class NingenmeNetUser {
  @NonNull
  private final Email email;
  @NonNull
  private final Password password;
  public static NingenmeNetUser of(Email email, Password password) {
    return new NingenmeNetUser(email, password);
  }
}
