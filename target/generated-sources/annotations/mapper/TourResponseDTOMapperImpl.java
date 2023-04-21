package mapper;

import domain.Tour;
import dto.TourResponseDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T17:00:02+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TourResponseDTOMapperImpl implements TourResponseDTOMapper {

    @Override
    public Tour convert(TourResponseDTO tourDTO) {
        if ( tourDTO == null ) {
            return null;
        }

        Tour tour = new Tour();

        return tour;
    }

    @Override
    public TourResponseDTO convert(Tour tour) {
        if ( tour == null ) {
            return null;
        }

        String title = null;
        Tour.TourStatus tourStatus = null;

        TourResponseDTO tourResponseDTO = new TourResponseDTO( title, tourStatus );

        return tourResponseDTO;
    }
}
