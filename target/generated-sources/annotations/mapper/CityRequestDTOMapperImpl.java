package mapper;

import domain.City;
import dto.CityRequestDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-25T09:27:03+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class CityRequestDTOMapperImpl implements CityRequestDTOMapper {

    @Override
    public City convert(CityRequestDTO cityRequestDTO) {
        if ( cityRequestDTO == null ) {
            return null;
        }

        City city = new City();

        city.setId( cityRequestDTO.id() );

        return city;
    }

    @Override
    public CityRequestDTO convert(City city) {
        if ( city == null ) {
            return null;
        }

        Long id = null;

        id = city.getId();

        CityRequestDTO cityRequestDTO = new CityRequestDTO( id );

        return cityRequestDTO;
    }
}
