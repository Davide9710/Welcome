package mapper;

import domain.City;
import domain.Tour;
import dto.CityDTO;
import dto.EditTourRequestDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T08:37:49+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EditTourRequestDTOMapperImpl implements EditTourRequestDTOMapper {

    @Override
    public Tour updateTourFromDto(EditTourRequestDTO editTourRequestDTO, Tour tour) {
        if ( editTourRequestDTO == null ) {
            return null;
        }

        tour.setTitle( editTourRequestDTO.title() );
        if ( editTourRequestDTO.city() != null ) {
            if ( tour.getCity() == null ) {
                tour.setCity( new City() );
            }
            cityDTOToCity( editTourRequestDTO.city(), tour.getCity() );
        }
        else {
            tour.setCity( null );
        }

        return tour;
    }

    protected void cityDTOToCity(CityDTO cityDTO, City mappingTarget) {
        if ( cityDTO == null ) {
            return;
        }

        mappingTarget.setName( cityDTO.name() );
    }
}
