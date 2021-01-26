package ningenme.net.api.domain.repository;

import ningenme.net.api.util.domain.entity.NingenmeNetUser;
import ningenme.net.api.domain.value.Email;

public interface ComproCategoryUserRepository {
  public void insert(NingenmeNetUser ningenmeNetUser);
  public NingenmeNetUser get(Email email);
}
