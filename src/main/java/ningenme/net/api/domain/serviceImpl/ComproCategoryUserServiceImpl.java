package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.util.domain.entity.NingenmeNetUser;
import ningenme.net.api.util.domain.repository.NingenmeNetUserMysqlRepository;
import ningenme.net.api.domain.service.ComproCategoryUserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComproCategoryUserServiceImpl implements ComproCategoryUserService {
  private final NingenmeNetUserMysqlRepository ningenmeNetUserMysqlRepository;

  @Override
  public void insert(NingenmeNetUser ningenmeNetUser) {
    ningenmeNetUserMysqlRepository.insert(ningenmeNetUser);
  }
}
