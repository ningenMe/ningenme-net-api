package ningenme.net.api.compro.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.compro.domain.repository.*;
import ningenme.net.api.compro.domain.value.ComproSite;
import ningenme.net.api.compro.domain.entity.Task;
import ningenme.net.api.compro.domain.service.TaskService;
import ningenme.net.api.util.domain.value.Url;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

  private final TaskAtcoderRepository taskAtcoderRepository;
  private final TaskCodeforcesRepository taskCodeforcesRepository;
  private final TaskYukicoderRepository taskYukicoderRepository;
  private final TaskAojRepository taskAojRepository;
  private final TaskAojBetaRepository taskAojBetaRepository;

  @Override
  public Task get(Url url) {
    ComproSite comproSite = ComproSite.of(url);
    if(comproSite.equals(ComproSite.ATCODER)) {
      return taskAtcoderRepository.get(url);
    }
    if(comproSite.equals(ComproSite.CODEFORCES)) {
      return taskCodeforcesRepository.get(url);
    }
    if(comproSite.equals(ComproSite.YUKICODER)) {
      return taskYukicoderRepository.get(url);
    }
    if(comproSite.equals(ComproSite.AOJ)) {
      return taskAojRepository.get(url);
    }
    if(comproSite.equals(ComproSite.AOJ_BETA)) {
      return taskAojBetaRepository.get(url);
    }
    return null;
  }
}
