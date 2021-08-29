package com.ca.musiccore.mapper;

import com.ca.musiccore.dto.SongDTO;
import com.ca.musiccore.events.song.SongRegisteredEvent;
import com.ca.musiccore.models.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SongMapper {

    SongMapper INSTANCE = Mappers.getMapper( SongMapper.class );

    @Mapping(source = "id", target = "id")
    @Mapping(source = "song.name", target = "name")
    @Mapping(source = "song.duration", target = "duration")
    @Mapping(source = "song.image", target = "image")
    @Mapping(source = "song.lyrics", target = "lyrics")
    @Mapping(source = "song.spotifyLink", target = "spotifyLink")
    @Mapping(source = "song.youtubeLink", target = "youtubeLink")
    @Mapping(source = "song.albumId", target = "albumId")
    @Mapping(source = "song.genreId", target = "genreId")
    @Mapping(source = "song.artistId", target = "artistId")
    Song songEventToSong(SongRegisteredEvent songRegisteredEvent);



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
    SongDTO songToSongDTO(Song song);


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
