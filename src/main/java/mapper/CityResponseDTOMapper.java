package mapper;

import domain.City;
import dto.CityResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface CityResponseDTOMapper {
    CityResponseDTOMapper INSTANCE = Mappers.getMapper(CityResponseDTOMapper.class);

    List<CityResponseDTO> convert(List<City> cities);

}
