package ningenme.net.api.util.infrastructure.mysql.dto;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.util.domain.entity.NingenmeNetUser;
import ningenme.net.api.domain.value.Email;
import ningenme.net.api.domain.value.Password;

import java.sql.Timestamp;

@RequiredArgsConstructor
public class NingenmeNetUserMysqlDto {
  private final String email;
  private final String password;
  private final Timestamp createdTime;
  private final Timestamp updatedTime;
  private final Timestamp deletedTime;
  public NingenmeNetUser convertComproCategoryUser() {
    return NingenmeNetUser.of(Email.of(email), Password.of(password));
  }
}
