package ningenme.net.api.domain.entity;

import java.sql.Timestamp;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Genre {

    @NonNull
    private final Integer genreId;
    @NonNull
    private final String name;
    @NonNull
    private final String label;
    @NonNull
    private final Integer order;
    @NonNull
    private final Timestamp createdTime;
    @NonNull
    private final Timestamp updatedTime;
    private final Timestamp deletedTime;

    public static Genre of(
        Integer genreId,
        String name,
        String label,
        Integer order,
        Timestamp createdTime,
        Timestamp updatedTime,
        Timestamp deletedTime
    ) {
        return new Genre(genreId,name,label,order,createdTime,updatedTime,deletedTime);
    }
}