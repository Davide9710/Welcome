package mapper;

import domain.City;
import domain.Tour;
import dto.CityResponseDTO;
import dto.TourResponseDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-22T12:38:23+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TourResponseDTOMapperImpl implements TourResponseDTOMapper {

    @Override
    public Tour convert(TourResponseDTO tourDTO) {
        if ( tourDTO == null ) {
            return null;
        }

        Tour tour = new Tour();

        tour.setTitle( tourDTO.title() );
        tour.setTourStatus( tourDTO.tourStatus() );
        tour.setCity( cityResponseDTOToCity( tourDTO.city() ) );

        return tour;
    }

    @Override
    public TourResponseDTO convert(Tour tour) {
        if ( tour == null ) {
            return null;
        }

        String title = null;
        Tour.TourStatus tourStatus = null;
        CityResponseDTO city = null;

        title = tour.getTitle();
        tourStatus = tour.getTourStatus();
        city = cityToCityResponseDTO( tour.getCity() );

        TourResponseDTO tourResponseDTO = new TourResponseDTO( title, tourStatus, city );

        return tourResponseDTO;
    }

    protected City cityResponseDTOToCity(CityResponseDTO cityResponseDTO) {
        if ( cityResponseDTO == null ) {
            return null;
        }

        City city = new City();

        city.setId( cityResponseDTO.id() );
        city.setName( cityResponseDTO.name() );

        return city;
    }

    protected CityResponseDTO cityToCityResponseDTO(City city) {
        if ( city == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = city.getId();
        name = city.getName();

        CityResponseDTO cityResponseDTO = new CityResponseDTO( id, name );

        return cityResponseDTO;
    }
}
