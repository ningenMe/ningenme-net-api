package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryUser;
import ningenme.net.api.domain.repository.ComproCategoryUserRepository;
import ningenme.net.api.domain.value.Email;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ComproCategoryUserDetailsServiceImpl implements UserDetailsService {

  private final ComproCategoryUserRepository comproCategoryUserRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    ComproCategoryUser comproCategoryUser = comproCategoryUserRepository.get(Email.of(username));

    if(Objects.isNull(comproCategoryUser)) {
      throw new UsernameNotFoundException("User Not Found");
    }

    //既存のUserクラスに直して返却(ここ実装いつか変えたほうが良い気はするけど一旦問題ないのでそのまま)
    return new User(comproCategoryUser.getEmail().toString(), comproCategoryUser.getPassword().toString(), AuthorityUtils.createAuthorityList("USER"));
  }
}
