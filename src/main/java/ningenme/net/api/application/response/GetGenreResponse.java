package ningenme.net.api.application.response;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.Genre;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GetGenreResponse {    
    private final List<Genre> genreList;

    public static GetGenreResponse of(List<Genre> genreList) {
        return new GetGenreResponse(genreList);
    }
}