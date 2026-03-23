package com.acgm.service.impl;

import com.acgm.model.Genre;
import com.acgm.repository.GenreRepository;
import com.acgm.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre createGenre(Genre genre) {

        return genreRepository.save(genre);
    }

}
