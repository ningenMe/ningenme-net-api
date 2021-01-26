package ningenme.net.api.compro.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.ComproSite;
import ningenme.net.api.compro.domain.service.AtcoderUserService;
import ningenme.net.api.compro.domain.service.SiteUserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SiteUserServiceImpl implements SiteUserService {
  private final static Integer ONE_PROCESS_ATCODER_USER_NUM = 100;
  private final static Long ONE_SEC = 1000L;
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
    //ATCODER
    if(comproSite.equals(ComproSite.ATCODER)) {
      for (int i = 0; i < ONE_PROCESS_ATCODER_USER_NUM; i++) {
        try{
          atcoderUserService.put();
          Thread.sleep(ONE_SEC);
        }
        catch (Exception ex) {
          continue;
        }
      }
    }
    //TODO そのうちほかも書く
  }
}
