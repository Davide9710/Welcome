package mapper;

import domain.Tour;
import dto.TourResponseDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T17:14:19+0200",
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

        return tour;
    }

    @Override
    public TourResponseDTO convert(Tour tour) {
        if ( tour == null ) {
            return null;
        }

        String title = null;
        Tour.TourStatus tourStatus = null;

        title = tour.getTitle();
        tourStatus = tour.getTourStatus();

        TourResponseDTO tourResponseDTO = new TourResponseDTO( title, tourStatus );

        return tourResponseDTO;
    }
}
