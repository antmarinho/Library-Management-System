package com.acgm.service.impl;

import com.acgm.mapper.GenreMapper;
import com.acgm.model.Genre;
import com.acgm.payload.dto.GenreDTO;
import com.acgm.repository.GenreRepository;
import com.acgm.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    private GenreMapper genreMapper;


    @Override
    public GenreDTO createGenre(GenreDTO genreDTO) {

        Genre genre = genreMapper.toEntity(genreDTO);

        Genre savedGenre = genreRepository.save(genre);

        return genreMapper.toDTO(savedGenre);

    }

    @Override
    public List<GenreDTO> getAllGenres() {

        return genreRepository.findAll().stream()
                .map(genreMapper::toDTO)
                .collect(Collectors.toList());

    }

}
