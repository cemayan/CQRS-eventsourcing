//package com.ca.musiccore.mapper;
//
//import com.ca.musiccore.events.SongRegisteredEvent;
//import com.ca.musiccore.models.Song;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//
//@Mapper
//public interface SongMapper {
//
//    SongMapper INSTANCE = Mappers.getMapper( SongMapper.class );
//
//    @Mapping(source = "song.name", target = "name")
//    @Mapping(source = "song.duration", target = "duration")
//    @Mapping(source = "song.image", target = "image")
//    @Mapping(source = "song.lyrics", target = "lyrics")
//    @Mapping(source = "song.spotifyLink", target = "spotifyLink")
//    @Mapping(source = "song.youtubeLink", target = "youtubeLink")
//    Song songEventToSong(SongRegisteredEvent songRegisteredEvent);
//
//
//}
