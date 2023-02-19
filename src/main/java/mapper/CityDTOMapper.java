package mapper;

import domain.City;
import dto.CityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityDTOMapper {
    CityDTOMapper INSTANCE = Mappers.getMapper(CityDTOMapper.class);

    void updateCityFromDto(CityDTO cityDTO, @MappingTarget City city);

    City convert(CityDTO tourDTO);

}
