package mapper;

import domain.City;
import dto.CityListResponseDTO;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface CityResponseDTOMapper {
    CityResponseDTOMapper INSTANCE = Mappers.getMapper(CityResponseDTOMapper.class);

    List<City> convert(CityListResponseDTO cityListResponseDTO);

    CityListResponseDTO convert(List<City> cities);
}
