package mapper;

import domain.Image;
import domain.TourStop;
import dto.GeographicCoordinatesDTO;
import dto.TourStopDTO;
import dto.TransportDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-22T12:38:23+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TourStopDTOMapperImpl implements TourStopDTOMapper {

    @Override
    public TourStop convert(TourStopDTO tourStopDTO) {
        if ( tourStopDTO == null ) {
            return null;
        }

        TourStop tourStop = new TourStop();

        tourStop.setTitle( tourStopDTO.title() );
        tourStop.setDescription( tourStopDTO.description() );
        tourStop.setCost( tourStopDTO.cost() );
        tourStop.setDuration( tourStopDTO.duration() );
        tourStop.setImages( stringListToImageList( tourStopDTO.images() ) );

        return tourStop;
    }

    @Override
    public TourStopDTO convert(TourStop tourStop) {
        if ( tourStop == null ) {
            return null;
        }

        String title = null;
        String description = null;
        Double cost = null;
        String duration = null;
        List<String> images = null;

        title = tourStop.getTitle();
        description = tourStop.getDescription();
        cost = tourStop.getCost();
        duration = tourStop.getDuration();
        images = imageListToStringList( tourStop.getImages() );

        String name = null;
        GeographicCoordinatesDTO coordinates = null;
        TransportDTO transportDTO = null;

        TourStopDTO tourStopDTO = new TourStopDTO( title, name, description, cost, duration, coordinates, transportDTO, images );

        return tourStopDTO;
    }

    @Override
    public List<TourStopDTO> convert(List<TourStopDTO> tourStop) {
        if ( tourStop == null ) {
            return null;
        }

        List<TourStopDTO> list = new ArrayList<TourStopDTO>( tourStop.size() );
        for ( TourStopDTO tourStopDTO : tourStop ) {
            list.add( tourStopDTO );
        }

        return list;
    }

    protected List<Image> stringListToImageList(List<String> list) {
        if ( list == null ) {
            return null;
        }

        List<Image> list1 = new ArrayList<Image>( list.size() );
        for ( String string : list ) {
            list1.add( convert( string ) );
        }

        return list1;
    }

    protected List<String> imageListToStringList(List<Image> list) {
        if ( list == null ) {
            return null;
        }

        List<String> list1 = new ArrayList<String>( list.size() );
        for ( Image image : list ) {
            list1.add( convert( image ) );
        }

        return list1;
    }
}
