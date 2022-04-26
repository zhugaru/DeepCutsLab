package zhugaru.dcl.mapsctruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import zhugaru.dcl.entity.ArtistEntity;
import zhugaru.dcl.mapsctruct.dto.ArtistDto;

@Mapper(componentModel = "spring")
public interface ArtistMapper {
    ArtistMapper INSTANCE = Mappers.getMapper(ArtistMapper.class);
    ArtistDto toDTO(ArtistEntity artist);
    ArtistEntity toArtist(ArtistDto artistDto);
}