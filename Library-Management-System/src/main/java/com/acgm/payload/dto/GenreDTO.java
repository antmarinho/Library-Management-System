package com.acgm.payload.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

public class GenreDTO {

    private Long id;

    @NotBlank(message = "codigo do genero e obrigatorio")
    private String code;

    @NotBlank(message = "nome do genero e obrigatorio")
    private String name;

    @Size(max = 500, message = "descricao nao pode ter mais de 500 caracteres")
    private String description;

    @Min(value = 0, message = "display nao pode ser negativo")
    private Integer displayOrder = 0;

    private Boolean active;

    private Long parentGenreId;

    private String parentGenreName;

    private List<GenreDTO> subGenre;

    private Long bookCount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public GenreDTO() {}

    public GenreDTO(LocalDateTime updatedAt, LocalDateTime createdAt, Long bookCount, List<GenreDTO> subGenre, String parentGenreName, Long parentGenreId, Boolean active, Integer displayOrder, String description, String name, String code, Long id) {

        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.bookCount = bookCount;
        this.subGenre = subGenre;
        this.parentGenreName = parentGenreName;
        this.parentGenreId = parentGenreId;
        this.active = active;
        this.displayOrder = displayOrder;
        this.description = description;
        this.name = name;
        this.code = code;
        this.id = id;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getParentGenreId() {
        return parentGenreId;
    }

    public void setParentGenreId(Long parentGenreId) {
        this.parentGenreId = parentGenreId;
    }

    public String getParentGenreName() {
        return parentGenreName;
    }

    public void setParentGenreName(String parentGenreName) {
        this.parentGenreName = parentGenreName;
    }

    public List<GenreDTO> getSubGenre() {
        return subGenre;
    }

    public void setSubGenre(List<GenreDTO> subGenre) {
        this.subGenre = subGenre;
    }

    public Long getBookCount() {
        return bookCount;
    }

    public void setBookCount(Long bookCount) {
        this.bookCount = bookCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
