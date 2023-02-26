package mapper;

import domain.City;
import dto.CityResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-26T17:16:10+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class CityResponseDTOMapperImpl implements CityResponseDTOMapper {

    @Override
    public List<CityResponseDTO> convert(List<City> cities) {
        if ( cities == null ) {
            return null;
        }

        List<CityResponseDTO> list = new ArrayList<CityResponseDTO>( cities.size() );
        for ( City city : cities ) {
            list.add( cityToCityResponseDTO( city ) );
        }

        return list;
    }

    protected CityResponseDTO cityToCityResponseDTO(City city) {
        if ( city == null ) {
            return null;
        }

        String name = null;

        name = city.getName();

        CityResponseDTO cityResponseDTO = new CityResponseDTO( name );

        return cityResponseDTO;
    }
}
