package mapper;

import domain.City;
import dto.CityRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityRequestDTOMapper {
    CityRequestDTOMapper INSTANCE = Mappers.getMapper(CityRequestDTOMapper.class);

    City convert(CityRequestDTO cityRequestDTO);

    CityRequestDTO convert(City city);

}
