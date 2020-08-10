package ningenme.net.api.presentation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.service.GenreService;
import ningenme.net.api.presentation.response.GetGenreResponse;

@RestController
@RequestMapping("/compro/category/genres")
@RequiredArgsConstructor
public class GenreController {
    
    private final GenreService genreService;

    @GetMapping("")
    public GetGenreResponse getGenre() {
        return GetGenreResponse.of(genreService.get());
    }
}