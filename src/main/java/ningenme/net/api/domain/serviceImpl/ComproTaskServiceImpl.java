package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.ComproSite;
import ningenme.net.api.domain.entity.ComproTask;
import ningenme.net.api.domain.repository.*;
import ningenme.net.api.domain.service.ComproTaskService;
import ningenme.net.api.domain.value.Url;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComproTaskServiceImpl implements ComproTaskService {

  private final ComproAtcoderTaskClientRepository    comproAtcoderTaskClientRepository;
  private final ComproCodeforcesTaskClientRepository comproCodeforcesTaskClientRepository;
  private final ComproYukicoderTaskClientRepository  comproYukicoderTaskClientRepository;
  private final ComproAojTaskClientRepository        comproAojTaskClientRepository;
  private final ComproAojBetaTaskClientRepository    comproAojBetaTaskClientRepository;

  @Override
  public ComproTask get(Url url) {
    ComproSite comproSite = ComproSite.of(url);
    if(comproSite.equals(ComproSite.ATCODER)) {
      return comproAtcoderTaskClientRepository.get(url);
    }
    if(comproSite.equals(ComproSite.CODEFORCES)) {
      return comproCodeforcesTaskClientRepository.get(url);
    }
    if(comproSite.equals(ComproSite.YUKICODER)) {
      return comproYukicoderTaskClientRepository.get(url);
    }
    if(comproSite.equals(ComproSite.AOJ)) {
      return comproAojTaskClientRepository.get(url);
    }
    if(comproSite.equals(ComproSite.AOJ_BETA)) {
      return comproAojBetaTaskClientRepository.get(url);
    }
    return null;
  }
}
