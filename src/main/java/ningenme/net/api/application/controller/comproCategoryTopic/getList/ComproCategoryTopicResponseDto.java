package ningenme.net.api.application.controller.comproCategoryTopic.getList;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComproCategoryGenre;
import ningenme.net.api.domain.entity.ComproCategoryTopic;

/**
 * レスポンス時のDTO, プリミティブ型のメンバのみで構成する
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "ComproCategoryTopicGetOneComproCategoryTopicResponseDto")
public class ComproCategoryTopicResponseDto {
  private final String topicId;
  private final String topicName;
  private final Integer topicOrder;
  private final String genreId;
  private final String genreName;
  public static ComproCategoryTopicResponseDto of(ComproCategoryTopic comproCategoryTopic) {
    return new ComproCategoryTopicResponseDto(
            comproCategoryTopic.getTopicId(),
            comproCategoryTopic.getTopicName(),
            comproCategoryTopic.getTopicOrder().getValue(),
            comproCategoryTopic.getGenreId(),
            comproCategoryTopic.getGenreName()
    );
  }
}