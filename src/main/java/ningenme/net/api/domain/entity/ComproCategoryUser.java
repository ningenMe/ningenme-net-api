package ningenme.net.api.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.Email;
import ningenme.net.api.domain.value.Password;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ComproCategoryUser {
  @NonNull
  private final Email email;
  @NonNull
  private final Password password;
  public static ComproCategoryUser of(Email email, Password password) {
    return new ComproCategoryUser(email, password);
  }
}
