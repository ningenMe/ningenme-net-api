package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproSite;
import ningenme.net.api.domain.service.AtcoderUserService;
import ningenme.net.api.domain.service.ComproSiteUserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComproSiteUserServiceImpl implements ComproSiteUserService {
  private final AtcoderUserService atcoderUserService;

  @Override
  @Async
  public void putId(ComproSite comproSite) {
    if(comproSite.equals(ComproSite.UNKNOWN)) {
      return;
    }
    if(comproSite.equals(ComproSite.ATCODER)) {
      atcoderUserService.putId();
    }
  }

  @Override
  @Async
  public void put(ComproSite comproSite) {
    if(comproSite.equals(ComproSite.UNKNOWN)) {
      return;
    }
    if(comproSite.equals(ComproSite.ATCODER)) {
      atcoderUserService.put();
    }
  }
}
