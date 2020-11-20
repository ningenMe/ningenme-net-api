package ningenme.net.api.application.controller.comproCategoryGenre.getListWithTopic.getList;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetList")
public class GetListWithTopicResponse {
  private final List<ComproCategoryGenreResponseDto> comproCategoryGenreList;
  public static GetListWithTopicResponse of(@NonNull List<ComproCategoryGenre> argComproCategoryGenreList) {
    return new GetListWithTopicResponse(
      argComproCategoryGenreList
              .stream()
              .map(
                      comproCategoryGenre -> ComproCategoryGenreResponseDto.of(comproCategoryGenre)
              )
            .collect(Collectors.toList())
    );
  }
}
