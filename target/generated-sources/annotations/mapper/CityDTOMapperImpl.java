package mapper;

import domain.City;
import dto.CityDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-25T09:27:03+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class CityDTOMapperImpl implements CityDTOMapper {

    @Override
    public void updateCityFromDto(CityDTO cityDTO, City city) {
        if ( cityDTO == null ) {
            return;
        }

        city.setName( cityDTO.name() );
    }

    @Override
    public City convert(CityDTO tourDTO) {
        if ( tourDTO == null ) {
            return null;
        }

        City city = new City();

        city.setName( tourDTO.name() );

        return city;
    }
}
