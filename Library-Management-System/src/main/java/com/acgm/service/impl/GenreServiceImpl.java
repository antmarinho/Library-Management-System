package com.acgm.service.impl;

import com.acgm.model.Genre;
import com.acgm.payload.dto.GenreDTO;
import com.acgm.repository.GenreRepository;
import com.acgm.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public GenreDTO createGenre(GenreDTO genreDTO) {

        Genre genre = new Genre();

        genre.setCode(genreDTO.getCode());
        genre.setName(genreDTO.getName());
        genre.setDescription(genreDTO.getDescription());
        genre.setDisplayOrder(genreDTO.getDisplayOrder());
        genre.setActive(genreDTO.getActive());

        if(genreDTO.getParentGenreId() != null) {

            Genre parentGenre = genreRepository.findById(genreDTO.getParentGenreId()).get();

            genre.setParentGenere(parentGenre);
        }

        Genre savedGenre = genreRepository.save(genre);

        GenreDTO dto = new GenreDTO();

        dto.setId(savedGenre.getId());
        dto.setCode(savedGenre.getCode());
        dto.setName(savedGenre.getName());
        dto.setDescription(savedGenre.getDescription());
        dto.setDisplayOrder(savedGenre.getDisplayOrder());
        dto.setActive(savedGenre.getActive());
        dto.setCreatedAt(savedGenre.getCreatedAt());
        dto.setUpdatedAt(savedGenre.getUpdateAt());

        if(savedGenre.getParentGenere() != null) {

            dto.setParentGenreId(savedGenre.getParentGenere().getId());

            dto.setParentGenreName(savedGenre.getParentGenere().getName());

        }

        //dto.setSubGenre(savedGenre.getSubGenres().stream()
               // .filter(subGenre -> subGenre.getActive())
               // .map(subGenre -> ));

        //dto.setBookCount((long) (savedGenre.get));

        return dto;

    }

}
