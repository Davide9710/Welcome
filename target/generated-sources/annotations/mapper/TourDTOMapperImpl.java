package mapper;

import domain.Tour;
import dto.TourDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-09T17:34:02+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TourDTOMapperImpl implements TourDTOMapper {

    @Override
    public Tour convert(TourDTO tourDTO) {
        if ( tourDTO == null ) {
            return null;
        }

        Tour tour = new Tour();

        return tour;
    }

    @Override
    public TourDTO convert(Tour tour) {
        if ( tour == null ) {
            return null;
        }

        TourDTO tourDTO = new TourDTO();

        return tourDTO;
    }

    @Override
    public List<TourDTO> convert(List<Tour> tours) {
        if ( tours == null ) {
            return null;
        }

        List<TourDTO> list = new ArrayList<TourDTO>( tours.size() );
        for ( Tour tour : tours ) {
            list.add( convert( tour ) );
        }

        return list;
    }
}
