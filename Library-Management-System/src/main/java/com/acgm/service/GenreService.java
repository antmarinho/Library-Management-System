package com.acgm.service;

import com.acgm.payload.dto.GenreDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenreService {

    GenreDTO createGenre(GenreDTO genre);

    List<GenreDTO> getAllGenres();

    GenreDTO getGenreById(Long genreId);

    GenreDTO updateGenre(Long genreId, GenreDTO genre);

    void deleteGenre(Long genreId);

    void hardDeleteGenre(Long genreId);

    List<GenreDTO> getAllActiveGenresWithSubGeneres();

    List<GenreDTO> getTopLevelGenres();

    Page<GenreDTO> searchGenres(String searchTerm, Pageable pageable);

    long getTotalActiveGenres();

    long getBookCountByGenreId(Long genreId);

}
