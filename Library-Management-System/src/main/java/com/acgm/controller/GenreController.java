package com.acgm.controller;

import com.acgm.model.Genre;
import com.acgm.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping("/create")
    public ResponseEntity<Genre> addGenre(@RequestBody Genre genre) {

        Genre createdGenre = genreService.createGenre(genre);

        return ResponseEntity.ok(createdGenre);
    }

}
