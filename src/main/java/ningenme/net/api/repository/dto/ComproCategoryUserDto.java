package ningenme.net.api.repository.dto;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryUser;

import java.sql.Timestamp;

@RequiredArgsConstructor
public class ComproCategoryUserDto {
  private final String email;
  private final String password;
  private final Timestamp createdTime;
  private final Timestamp updatedTime;
  private final Timestamp deletedTime;
  public static ComproCategoryUserDto of(ComproCategoryUser comproCategoryUser) {
    return new ComproCategoryUserDto(
            comproCategoryUser.getEmail().toString(),
            comproCategoryUser.getPassword().toString(),
            null,null,null);
  }
}
