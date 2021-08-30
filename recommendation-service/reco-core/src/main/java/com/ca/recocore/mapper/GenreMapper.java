package com.ca.recocore.mapper;


import com.ca.recocore.dto.music.GenreDTO;
import com.ca.recocore.models.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {

    GenreMapper INSTANCE = Mappers.getMapper( GenreMapper.class );

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    Genre genreDTOToGenre(GenreDTO genreDTO);

}
