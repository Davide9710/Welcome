package mapper;

import domain.Image;
import domain.Tag;
import domain.Theme;
import domain.Tour;
import domain.TourStop;
import dto.CityRequestDTO;
import dto.CreateTourRequestDTO;
import dto.GeographicCoordinatesDTO;
import dto.TagRequestDTO;
import dto.ThemeDTO;
import dto.TourStopDTO;
import dto.TransportDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-06T18:22:29+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class CreateTourRequestDTOMapperImpl implements CreateTourRequestDTOMapper {

    @Override
    public CreateTourRequestDTO convert(Tour tour) {
        if ( tour == null ) {
            return null;
        }

        String title = null;
        ThemeDTO theme = null;
        List<TagRequestDTO> tags = null;
        String approxDuration = null;
        Double approxCost = null;
        List<TourStopDTO> stops = null;

        title = tour.getTitle();
        theme = themeToThemeDTO( tour.getTheme() );
        tags = tagListToTagRequestDTOList( tour.getTags() );
        approxDuration = tour.getApproxDuration();
        approxCost = tour.getApproxCost();
        stops = tourStopListToTourStopDTOList( tour.getStops() );

        CityRequestDTO cityRequestDTO = null;

        CreateTourRequestDTO createTourRequestDTO = new CreateTourRequestDTO( title, cityRequestDTO, theme, tags, approxDuration, approxCost, stops );

        return createTourRequestDTO;
    }

    @Override
    public Tour convert(CreateTourRequestDTO createTourRequestDTO) {
        if ( createTourRequestDTO == null ) {
            return null;
        }

        Tour tour = new Tour();

        tour.setTitle( createTourRequestDTO.title() );
        tour.setApproxCost( createTourRequestDTO.approxCost() );
        tour.setApproxDuration( createTourRequestDTO.approxDuration() );
        tour.setStops( tourStopDTOListToTourStopList( createTourRequestDTO.stops() ) );
        tour.setTags( tagRequestDTOListToTagList( createTourRequestDTO.tags() ) );
        tour.setTheme( themeDTOToTheme( createTourRequestDTO.theme() ) );

        return tour;
    }

    protected ThemeDTO themeToThemeDTO(Theme theme) {
        if ( theme == null ) {
            return null;
        }

        String name = null;

        name = theme.getName();

        ThemeDTO themeDTO = new ThemeDTO( name );

        return themeDTO;
    }

    protected TagRequestDTO tagToTagRequestDTO(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = tag.getId();
        name = tag.getName();

        TagRequestDTO tagRequestDTO = new TagRequestDTO( id, name );

        return tagRequestDTO;
    }

    protected List<TagRequestDTO> tagListToTagRequestDTOList(List<Tag> list) {
        if ( list == null ) {
            return null;
        }

        List<TagRequestDTO> list1 = new ArrayList<TagRequestDTO>( list.size() );
        for ( Tag tag : list ) {
            list1.add( tagToTagRequestDTO( tag ) );
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

    protected TourStopDTO tourStopToTourStopDTO(TourStop tourStop) {
        if ( tourStop == null ) {
            return null;
        }

        String title = null;
        String description = null;
        Double cost = null;
        List<String> images = null;

        title = tourStop.getTitle();
        description = tourStop.getDescription();
        cost = tourStop.getCost();
        images = imageListToStringList( tourStop.getImages() );

        String name = null;
        GeographicCoordinatesDTO coordinates = null;
        TransportDTO transportDTO = null;

        TourStopDTO tourStopDTO = new TourStopDTO( title, name, description, cost, coordinates, transportDTO, images );

        return tourStopDTO;
    }

    protected List<TourStopDTO> tourStopListToTourStopDTOList(List<TourStop> list) {
        if ( list == null ) {
            return null;
        }

        List<TourStopDTO> list1 = new ArrayList<TourStopDTO>( list.size() );
        for ( TourStop tourStop : list ) {
            list1.add( tourStopToTourStopDTO( tourStop ) );
        }

        return list1;
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

    protected TourStop tourStopDTOToTourStop(TourStopDTO tourStopDTO) {
        if ( tourStopDTO == null ) {
            return null;
        }

        TourStop tourStop = new TourStop();

        tourStop.setTitle( tourStopDTO.title() );
        tourStop.setDescription( tourStopDTO.description() );
        tourStop.setCost( tourStopDTO.cost() );
        tourStop.setImages( stringListToImageList( tourStopDTO.images() ) );

        return tourStop;
    }

    protected List<TourStop> tourStopDTOListToTourStopList(List<TourStopDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<TourStop> list1 = new ArrayList<TourStop>( list.size() );
        for ( TourStopDTO tourStopDTO : list ) {
            list1.add( tourStopDTOToTourStop( tourStopDTO ) );
        }

        return list1;
    }

    protected Tag tagRequestDTOToTag(TagRequestDTO tagRequestDTO) {
        if ( tagRequestDTO == null ) {
            return null;
        }

        Tag tag = new Tag();

        tag.setId( tagRequestDTO.id() );
        tag.setName( tagRequestDTO.name() );

        return tag;
    }

    protected List<Tag> tagRequestDTOListToTagList(List<TagRequestDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Tag> list1 = new ArrayList<Tag>( list.size() );
        for ( TagRequestDTO tagRequestDTO : list ) {
            list1.add( tagRequestDTOToTag( tagRequestDTO ) );
        }

        return list1;
    }

    protected Theme themeDTOToTheme(ThemeDTO themeDTO) {
        if ( themeDTO == null ) {
            return null;
        }

        Theme theme = new Theme();

        theme.setName( themeDTO.name() );

        return theme;
    }
}
