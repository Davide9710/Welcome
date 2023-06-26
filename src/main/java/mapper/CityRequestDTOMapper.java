package mapper;

import domain.City;
import dto.CityRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface CityRequestDTOMapper {
    CityRequestDTOMapper INSTANCE = Mappers.getMapper(CityRequestDTOMapper.class);

    City convert(CityRequestDTO cityRequestDTO);

    CityRequestDTO convert(City city);

}
