package ningenme.net.api.repository.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.Genre;

@RequiredArgsConstructor
@Getter
public class GenreDto {
    private final Integer genreId;
    private final String name;
    private final String label;
    private final Integer order;
    private final Timestamp createdTime;
    private final Timestamp updatedTime;
    private final Timestamp deletedTime;

    public Genre convertGenre() {
        return Genre.of(genreId, name, label, order, createdTime, updatedTime, deletedTime);
    }
}