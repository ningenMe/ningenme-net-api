package ningenme.net.api.util.domain.repository;

import ningenme.net.api.util.domain.entity.NingenmeNetUser;
import ningenme.net.api.domain.value.Email;

public interface NingenmeNetUserMysqlRepository {
  public void insert(NingenmeNetUser ningenmeNetUser);
  public NingenmeNetUser get(Email email);
}
