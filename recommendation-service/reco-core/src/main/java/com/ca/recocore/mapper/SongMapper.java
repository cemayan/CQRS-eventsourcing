package com.ca.recocore.mapper;

import com.ca.recocore.dto.music.SongDTO;
import com.ca.recocore.models.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SongMapper {

    SongMapper INSTANCE = Mappers.getMapper( SongMapper.class );


    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "lyrics", target = "lyrics")
    @Mapping(source = "spotifyLink", target = "spotifyLink")
    @Mapping(source = "youtubeLink", target = "youtubeLink")
    @Mapping(source = "albumId", target = "albumId")
    @Mapping(source = "genreId", target = "genreId")
    @Mapping(source = "artistId", target = "artistId")
    Song songDTOToSong(SongDTO song);

}
