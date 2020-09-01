package ningenme.net.api.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.service.GenreService;
import ningenme.net.api.presentation.response.GetGenreOneResponse;
import ningenme.net.api.presentation.response.GetGenreResponse;

@RestController
@RequestMapping("/compro/category/genres")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @GetMapping("")
    public ResponseEntity<GetGenreResponse> getGenre() {
        return ResponseEntity.ok().body(GetGenreResponse.of(genreService.get()));
    }
    @GetMapping("/{label}")
    public ResponseEntity<GetGenreOneResponse> getGenreOne(
        @PathVariable String label
    ) {
        return ResponseEntity.ok().body(GetGenreOneResponse.of(genreService.get(label)));
    }

}