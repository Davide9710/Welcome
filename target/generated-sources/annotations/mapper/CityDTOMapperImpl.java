package mapper;

import domain.City;
import dto.CityDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-09T17:34:02+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class CityDTOMapperImpl implements CityDTOMapper {

    @Override
    public void updateCityFromDto(CityDTO cityDTO, City city) {
        if ( cityDTO == null ) {
            return;
        }
    }
}
