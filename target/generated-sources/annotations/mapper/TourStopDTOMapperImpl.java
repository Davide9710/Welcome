package mapper;

import domain.Image;
import domain.TourStop;
import domain.Transport;
import dto.GeographicCoordinatesDTO;
import dto.TourStopDTO;
import dto.TransportDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-25T09:27:03+0200",
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
        tourStop.setTransport( transportDTOToTransport( tourStopDTO.transport() ) );
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
        TransportDTO transport = null;
        List<String> images = null;

        title = tourStop.getTitle();
        description = tourStop.getDescription();
        cost = tourStop.getCost();
        duration = tourStop.getDuration();
        transport = transportToTransportDTO( tourStop.getTransport() );
        images = imageListToStringList( tourStop.getImages() );

        String name = null;
        GeographicCoordinatesDTO coordinates = null;

        TourStopDTO tourStopDTO = new TourStopDTO( title, name, description, cost, duration, coordinates, transport, images );

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

    protected Transport transportDTOToTransport(TransportDTO transportDTO) {
        if ( transportDTO == null ) {
            return null;
        }

        Transport transport = new Transport();

        transport.setTransportCost( transportDTO.transportCost() );
        transport.setTransportDuration( transportDTO.transportDuration() );
        transport.setTransportType( transportDTO.transportType() );
        transport.setTransportDetails( transportDTO.transportDetails() );
        transport.setTransportOtherOptions( transportDTO.transportOtherOptions() );

        return transport;
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

    protected TransportDTO transportToTransportDTO(Transport transport) {
        if ( transport == null ) {
            return null;
        }

        Double transportCost = null;
        String transportDuration = null;
        String transportType = null;
        String transportDetails = null;
        String transportOtherOptions = null;

        transportCost = transport.getTransportCost();
        transportDuration = transport.getTransportDuration();
        transportType = transport.getTransportType();
        transportDetails = transport.getTransportDetails();
        transportOtherOptions = transport.getTransportOtherOptions();

        TransportDTO transportDTO = new TransportDTO( transportCost, transportDuration, transportType, transportDetails, transportOtherOptions );

        return transportDTO;
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
