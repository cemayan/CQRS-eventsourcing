package com.ca.musiccore.mapper;

import com.ca.musiccore.events.album.AlbumRegisteredEvent;
import com.ca.musiccore.events.song.SongRegisteredEvent;
import com.ca.musiccore.models.Album;
import com.ca.musiccore.models.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlbumMapper {

    AlbumMapper INSTANCE = Mappers.getMapper( AlbumMapper.class );

    @Mapping(source = "id", target = "id")
    @Mapping(source = "album.name", target = "name")
    @Mapping(source = "album.recordLabel", target = "recordLabel")
    @Mapping(source = "album.year", target = "year")
    @Mapping(source = "album.releaseDate", target = "releaseDate")
    @Mapping(source = "album.genre", target = "genre")
    @Mapping(source = "album.artistId", target = "artistId")
    Album albumEventToAlbum(AlbumRegisteredEvent albumRegisteredEvent);


}
