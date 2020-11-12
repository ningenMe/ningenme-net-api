package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryTask;
import ningenme.net.api.domain.repository.ComproCategoryTaskRepository;
import ningenme.net.api.domain.service.ComproCategoryTaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComproCategoryTaskServiceImpl implements ComproCategoryTaskService {
  private final ComproCategoryTaskRepository comproCategoryTaskRepository;

  @Override
  public List<ComproCategoryTask> get(Integer offset) {
    return comproCategoryTaskRepository.get(offset);
  }
}