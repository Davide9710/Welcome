package mapper;

import domain.Image;
import domain.TourStop;
import dto.GeographicCoordinatesDTO;
import dto.ImageDTO;
import dto.TourStopDTO;
import dto.TransportDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-26T17:16:10+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
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
        tourStop.setImages( imageDTOListToImageList( tourStopDTO.images() ) );

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
        List<ImageDTO> images = null;

        title = tourStop.getTitle();
        description = tourStop.getDescription();
        cost = tourStop.getCost();
        images = imageListToImageDTOList( tourStop.getImages() );

        String name = null;
        GeographicCoordinatesDTO geographicCoordinatesDTO = null;
        TransportDTO transportDTO = null;

        TourStopDTO tourStopDTO = new TourStopDTO( title, name, description, cost, geographicCoordinatesDTO, transportDTO, images );

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

    protected Image imageDTOToImage(ImageDTO imageDTO) {
        if ( imageDTO == null ) {
            return null;
        }

        Image image1 = new Image();

        Byte[] image = imageDTO.image();
        if ( image != null ) {
            image1.setImage( Arrays.copyOf( image, image.length ) );
        }

        return image1;
    }

    protected List<Image> imageDTOListToImageList(List<ImageDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Image> list1 = new ArrayList<Image>( list.size() );
        for ( ImageDTO imageDTO : list ) {
            list1.add( imageDTOToImage( imageDTO ) );
        }

        return list1;
    }

    protected ImageDTO imageToImageDTO(Image image) {
        if ( image == null ) {
            return null;
        }

        Byte[] image1 = null;

        Byte[] image2 = image.getImage();
        if ( image2 != null ) {
            image1 = Arrays.copyOf( image2, image2.length );
        }

        ImageDTO imageDTO = new ImageDTO( image1 );

        return imageDTO;
    }

    protected List<ImageDTO> imageListToImageDTOList(List<Image> list) {
        if ( list == null ) {
            return null;
        }

        List<ImageDTO> list1 = new ArrayList<ImageDTO>( list.size() );
        for ( Image image : list ) {
            list1.add( imageToImageDTO( image ) );
        }

        return list1;
    }
}
