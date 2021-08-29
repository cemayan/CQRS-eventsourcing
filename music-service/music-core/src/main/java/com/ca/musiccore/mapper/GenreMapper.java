package com.ca.musiccore.mapper;

import com.ca.musiccore.dto.GenreDTO;
import com.ca.musiccore.events.album.AlbumRegisteredEvent;
import com.ca.musiccore.events.genre.GenreRegisteredEvent;
import com.ca.musiccore.models.Album;
import com.ca.musiccore.models.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {

    GenreMapper INSTANCE = Mappers.getMapper( GenreMapper.class );

    @Mapping(source = "id", target = "id")
    @Mapping(source = "genre.name", target = "name")
    Genre genreEventToGenre(GenreRegisteredEvent genreRegisteredEvent);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    Genre genreDTOToGenre(GenreDTO genreDTO);

}
