package ningenme.net.api.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.Email;
import ningenme.net.api.domain.value.Password;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ComproCategoryUser {
  private final Email email;
  private final Password password;
  public static ComproCategoryUser of(Email email, Password password) {
    return new ComproCategoryUser(email, password);
  }
}
