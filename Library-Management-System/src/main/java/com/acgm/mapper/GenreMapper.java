package com.acgm.mapper;

import com.acgm.model.Genre;
import com.acgm.payload.dto.GenreDTO;
import com.acgm.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class GenreMapper {

    @Autowired
    private GenreRepository genreRepository;

    public GenreDTO toDTO(Genre savedGenre) {

        if(savedGenre == null)
            return null;

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

        if(savedGenre.getSubGenres() != null && !savedGenre.getSubGenres().isEmpty()) {

            dto.setSubGenre(savedGenre.getSubGenres().stream()
                    .filter(Genre::getActive)
                    .map(this::toDTO).collect(Collectors.toList()));

        }

        //dto.setBookCount((long) (savedGenre.get));

        return dto;

    }

    public Genre toEntity(GenreDTO genreDTO) {

        if(genreDTO == null) {
            return null;
        }

            Genre genre = new Genre();

            genre.setCode(genreDTO.getCode());
            genre.setName(genreDTO.getName());
            genre.setDescription(genreDTO.getDescription());
            genre.setDisplayOrder(genreDTO.getDisplayOrder());
            genre.setActive(genreDTO.getActive());

            if(genreDTO.getParentGenreId() != null) {

                genreRepository.findById(genreDTO.getParentGenreId()).
                        ifPresent(genre::setParentGenere);

            }

        return genre;

    }

}
