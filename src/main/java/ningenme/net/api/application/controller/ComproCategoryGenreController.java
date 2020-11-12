package ningenme.net.api.application.controller;

import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.service.GenreService;
import ningenme.net.api.application.response.GetGenreOneResponse;
import ningenme.net.api.application.response.GetGenreResponse;

@RestController
@RequiredArgsConstructor
public class ComproCategoryGenreController {
    private final GenreService genreService;

    @ApiOperation(value = "ComproCategoryGenre 複数参照API")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/v1/compro/category/genres")
    public ResponseEntity<GetGenreResponse> getGenres() {
        return ResponseEntity.ok().body(GetGenreResponse.of(genreService.get()));
    }

    @ApiOperation(value = "ComproCategoryGenre 単体参照API")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/v1/compro/category/genres/{label}")
    public ResponseEntity<GetGenreOneResponse> getGenreOne(
        @ApiParam("ラベル") @PathVariable String label
    ) {
        return ResponseEntity.ok().body(GetGenreOneResponse.of(genreService.get(label)));
    }

}