package ningenme.net.api.application.controller.comproCategoryGenre.getOneWithTopic;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetOneWithTopic")
public class GetOneWithTopicResponse {
  private final ComproCategoryGenreResponseDto comproCategoryGenre;
  public static GetOneWithTopicResponse of(@NonNull ComproCategoryGenre argComproCategoryGenre) {
    return new GetOneWithTopicResponse(ComproCategoryGenreResponseDto.of(argComproCategoryGenre));
  }
}
