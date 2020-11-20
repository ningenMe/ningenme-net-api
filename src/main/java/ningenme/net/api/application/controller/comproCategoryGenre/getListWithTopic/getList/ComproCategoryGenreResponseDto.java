package ningenme.net.api.application.controller.comproCategoryGenre.getListWithTopic.getList;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;

import java.util.List;
import java.util.stream.Collectors;

/**
 * レスポンス時のDTO, プリミティブ型のメンバのみで構成する
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryGenreGetListComproCategoryGenreResponseDto")
public class ComproCategoryGenreResponseDto {
  private final String genreId;
  private final String genreName;
  private final String label;
  private final Integer genreOrder;
  private final List<ComproCategoryTopicResponseDto> comproCategoryTopicList;
  public static ComproCategoryGenreResponseDto of(ComproCategoryGenre comproCategoryGenre) {
    return new ComproCategoryGenreResponseDto(
            comproCategoryGenre.getGenreId(),
            comproCategoryGenre.getGenreName(),
            comproCategoryGenre.getLabel().getValue(),
            comproCategoryGenre.getGenreOrder().getValue(),
            comproCategoryGenre.getComproCategoryTopicList()
                    .stream()
                    .map(comproCategoryTopic -> ComproCategoryTopicResponseDto.of(comproCategoryTopic))
                    .collect(Collectors.toList())
    );
  }
}
