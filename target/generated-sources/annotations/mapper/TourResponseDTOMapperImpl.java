package mapper;

import domain.Tour;
import domain.Tour.TourStatus;
import dto.TourResponseDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T16:21:55+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TourResponseDTOMapperImpl implements TourResponseDTOMapper {

    @Override
    public Tour convert(TourResponseDTO tourDTO) {
        if ( tourDTO == null ) {
            return null;
        }

        Tour tour = new Tour();

        tour.setTourStatus( tourDTO.tourStatus() );
        tour.setTitle( tourDTO.title() );

        return tour;
    }

    @Override
    public TourResponseDTO convert(Tour tour) {
        if ( tour == null ) {
            return null;
        }

        String title = null;
        TourStatus tourStatus = null;

        title = tour.getTitle();
        tourStatus = tour.getTourStatus();

        TourResponseDTO tourResponseDTO = new TourResponseDTO( title, tourStatus );

        return tourResponseDTO;
    }
}
