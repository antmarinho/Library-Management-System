package com.acgm.controller;

import com.acgm.payload.dto.GenreDTO;
import com.acgm.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping("/create")
    public ResponseEntity<GenreDTO> addGenre(@RequestBody GenreDTO genreDTO) {

        GenreDTO createdGenre = genreService.createGenre(genreDTO);

        return ResponseEntity.ok(createdGenre);

    }

    @GetMapping()
    public ResponseEntity<?> getAllGenre() {

        List<GenreDTO> genres = genreService.getAllGenres();

        return ResponseEntity.ok(genres);

    }

}
