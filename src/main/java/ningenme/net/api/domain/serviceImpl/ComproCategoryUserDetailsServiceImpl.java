package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.util.domain.entity.NingenmeNetUser;
import ningenme.net.api.util.domain.repository.NingenmeNetUserMysqlRepository;
import ningenme.net.api.domain.value.Email;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ComproCategoryUserDetailsServiceImpl implements UserDetailsService {

  private final NingenmeNetUserMysqlRepository ningenmeNetUserMysqlRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    NingenmeNetUser ningenmeNetUser = ningenmeNetUserMysqlRepository.get(Email.of(username));

    if(Objects.isNull(ningenmeNetUser)) {
      throw new UsernameNotFoundException("NingenmeNetUser Not Found");
    }

    //既存のUserクラスに直して返却(ここ実装いつか変えたほうが良い気はするけど一旦問題ないのでそのまま)
    return new org.springframework.security.core.userdetails.User(ningenmeNetUser.getEmail().toString(), ningenmeNetUser.getPassword().toString(), AuthorityUtils.createAuthorityList("USER"));
  }
}
