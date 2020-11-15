package ningenme.net.api.application.controller.comproCategoryGenre.getOne;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetOne")
public class GetOneResponse {
  private final ComproCategoryGenreResponseDto comproCategoryGenre;
  public static GetOneResponse of(@NonNull ComproCategoryGenre argComproCategoryGenre) {
    return new GetOneResponse(ComproCategoryGenreResponseDto.of(argComproCategoryGenre));
  }
}
