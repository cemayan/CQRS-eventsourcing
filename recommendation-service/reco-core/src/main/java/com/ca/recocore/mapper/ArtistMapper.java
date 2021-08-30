package com.ca.recocore.mapper;


import com.ca.recocore.dto.music.ArtistDTO;
import com.ca.recocore.models.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArtistMapper {

    ArtistMapper INSTANCE = Mappers.getMapper( ArtistMapper.class );

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    Artist artistDTOToArtist(ArtistDTO artistDTO);
}
