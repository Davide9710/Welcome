package mapper;

import domain.City;
import dto.CityResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CityResponseDTOMapper {
    CityResponseDTOMapper INSTANCE = Mappers.getMapper(CityResponseDTOMapper.class);

    List<CityResponseDTO> convert(List<City> cities);

}
