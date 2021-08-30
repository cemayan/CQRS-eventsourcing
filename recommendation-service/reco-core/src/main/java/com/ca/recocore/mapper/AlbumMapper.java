package com.ca.recocore.mapper;



import com.ca.recocore.dto.music.AlbumDTO;
import com.ca.recocore.models.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlbumMapper {

    AlbumMapper INSTANCE = Mappers.getMapper( AlbumMapper.class );


    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "recordLabel", target = "recordLabel")
    @Mapping(source = "year", target = "year")
    @Mapping(source = "releaseDate", target = "releaseDate")
    @Mapping(source = "artistId", target = "artistId")
    Album albumDTOToAlbum(AlbumDTO albumDTO);
}
