package ningenme.net.api.application.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.Genre;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GetGenreOneResponse {    
    private final Genre genre;

    public static GetGenreOneResponse of(Genre genre) {
        return new GetGenreOneResponse(genre);
    }
}