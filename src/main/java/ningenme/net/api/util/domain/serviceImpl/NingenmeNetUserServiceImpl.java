package ningenme.net.api.util.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.util.domain.service.NingenmeNetUserService;
import ningenme.net.api.util.domain.entity.NingenmeNetUser;
import ningenme.net.api.util.domain.repository.NingenmeNetUserMysqlRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NingenmeNetUserServiceImpl implements NingenmeNetUserService {
  private final NingenmeNetUserMysqlRepository ningenmeNetUserMysqlRepository;

  @Override
  public void insert(NingenmeNetUser ningenmeNetUser) {
    ningenmeNetUserMysqlRepository.insert(ningenmeNetUser);
  }
}
