package mapper;

import domain.City;
import dto.CityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface CityDTOMapper {
    void updateCityFromDto(CityDTO cityDTO, @MappingTarget City city);
}
