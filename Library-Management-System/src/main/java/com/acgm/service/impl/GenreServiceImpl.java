package com.acgm.service.impl;

import com.acgm.mapper.GenreMapper;
import com.acgm.model.Genre;
import com.acgm.payload.dto.GenreDTO;
import com.acgm.repository.GenreRepository;
import com.acgm.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public GenreDTO getGenreById(Long genreId) {
        return null;
    }

    @Override
    public GenreDTO updateGenre(Long genreId, GenreDTO genre) {
        return null;
    }

    @Override
    public void deleteGenre(Long genreId) {

    }

    @Override
    public void hardDeleteGenre(Long genreId) {

    }

    @Override
    public List<GenreDTO> getAllActiveGenresWithSubGeneres() {
        return List.of();
    }

    @Override
    public List<GenreDTO> getTopLevelGenres() {
        return List.of();
    }

    @Override
    public Page<GenreDTO> searchGenres(String searchTerm, Pageable pageable) {
        return null;
    }

    @Override
    public long getTotalActiveGenres() {
        return 0;
    }

    @Override
    public long getBookCountByGenreId(Long genreId) {
        return 0;
    }

}
