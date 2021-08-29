package com.ca.musiccmdapi.mapper;

import com.ca.musiccmdapi.commands.RegisterAllSongCommand;
import com.ca.musiccmdapi.commands.RegisterSongCommand;
import com.ca.musiccore.events.song.AllSongRegisteredEvent;
import com.ca.musiccore.events.song.SongRegisteredEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MusicCommandMapper {

    MusicCommandMapper INSTANCE = Mappers.getMapper( MusicCommandMapper.class );

    @Mapping(source = "id", target = "id")
    @Mapping(source = "song", target = "song")
    SongRegisteredEvent registerSongCommandToSongRegisteredEvent(RegisterSongCommand registerSongCommand);



    @Mapping(source = "id", target = "id")
    @Mapping(source = "song", target = "song")
    @Mapping(source = "id", target = "song.id")
    @Mapping(source = "album", target = "album")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "artist", target = "artist")
    AllSongRegisteredEvent registerSongCommandToAllSongRegisteredEvent(RegisterAllSongCommand registerSongCommand);


}
