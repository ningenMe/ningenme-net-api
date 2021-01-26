package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.util.domain.entity.NingenmeNetUser;
import ningenme.net.api.domain.repository.ComproCategoryUserRepository;
import ningenme.net.api.domain.service.ComproCategoryUserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComproCategoryUserServiceImpl implements ComproCategoryUserService {
  private final ComproCategoryUserRepository comproCategoryUserRepository;

  @Override
  public void insert(NingenmeNetUser ningenmeNetUser) {
    comproCategoryUserRepository.insert(ningenmeNetUser);
  }
}
