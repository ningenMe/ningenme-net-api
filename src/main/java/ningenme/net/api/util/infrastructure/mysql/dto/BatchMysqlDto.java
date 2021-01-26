package ningenme.net.api.util.infrastructure.mysql.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BatchMysqlDto {
  private final String name;
  private final String info;
}
