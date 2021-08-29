package com.ca.musiccore.mapper;

import com.ca.musiccore.dto.ArtistDTO;
import com.ca.musiccore.dto.GenreDTO;
import com.ca.musiccore.events.album.AlbumRegisteredEvent;
import com.ca.musiccore.events.artist.ArtistRegisteredEvent;
import com.ca.musiccore.models.Album;
import com.ca.musiccore.models.Artist;
import com.ca.musiccore.models.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArtistMapper {

    ArtistMapper INSTANCE = Mappers.getMapper( ArtistMapper.class );

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist.name", target = "name")
    Artist artistEventToArtist(ArtistRegisteredEvent artistRegisteredEvent);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    Artist artistDTOToArtist(ArtistDTO artistDTO);
}
