package ningenme.net.api.util.infrastructure.mysql.dto;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryUser;
import ningenme.net.api.domain.value.Email;
import ningenme.net.api.domain.value.Password;

import java.sql.Timestamp;

@RequiredArgsConstructor
public class UserMysqlDto {
  private final String email;
  private final String password;
  private final Timestamp createdTime;
  private final Timestamp updatedTime;
  private final Timestamp deletedTime;
  public ComproCategoryUser convertComproCategoryUser() {
    return ComproCategoryUser.of(Email.of(email), Password.of(password));
  }
}
