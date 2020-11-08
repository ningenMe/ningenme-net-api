package ningenme.net.api.domain.repository;

import ningenme.net.api.domain.entity.ComproCategoryUser;
import ningenme.net.api.domain.value.Email;

public interface ComproCategoryUserRepository {
  public void insert(ComproCategoryUser comproCategoryUser);
  public ComproCategoryUser get(Email email);
}
