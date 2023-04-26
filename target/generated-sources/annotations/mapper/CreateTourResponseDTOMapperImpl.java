package mapper;

import domain.City;
import domain.Tag;
import domain.Theme;
import domain.Tour;
import dto.CityDTO;
import dto.CreateTourResponseDTO;
import dto.TagResponseDTO;
import dto.ThemeDTO;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-25T09:27:03+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class CreateTourResponseDTOMapperImpl implements CreateTourResponseDTOMapper {

    @Override
    public CreateTourResponseDTO convert(Tour tour) {
        if ( tour == null ) {
            return null;
        }

        String title = null;
        Double approxCost = null;
        String approxDuration = null;
        Instant creationTime = null;
        Instant lastUpdate = null;
        CityDTO city = null;
        List<TagResponseDTO> tags = null;
        ThemeDTO theme = null;

        title = tour.getTitle();
        approxCost = tour.getApproxCost();
        approxDuration = tour.getApproxDuration();
        creationTime = tour.getCreationTime();
        lastUpdate = tour.getLastUpdate();
        city = cityToCityDTO( tour.getCity() );
        tags = tagSetToTagResponseDTOList( tour.getTags() );
        theme = themeToThemeDTO( tour.getTheme() );

        Tour.TourStatus tourStatus = null;

        CreateTourResponseDTO createTourResponseDTO = new CreateTourResponseDTO( title, approxCost, approxDuration, tourStatus, creationTime, lastUpdate, city, tags, theme );

        return createTourResponseDTO;
    }

    @Override
    public Tour convert(CreateTourResponseDTO createTourResponseDTO) {
        if ( createTourResponseDTO == null ) {
            return null;
        }

        Tour tour = new Tour();

        tour.setTheme( themeDTOToTheme( createTourResponseDTO.theme() ) );
        tour.setTitle( createTourResponseDTO.title() );
        tour.setApproxCost( createTourResponseDTO.approxCost() );
        tour.setApproxDuration( createTourResponseDTO.approxDuration() );
        tour.setCreationTime( createTourResponseDTO.creationTime() );
        tour.setLastUpdate( createTourResponseDTO.lastUpdate() );
        tour.setCity( cityDTOToCity( createTourResponseDTO.city() ) );
        tour.setTags( tagResponseDTOListToTagSet( createTourResponseDTO.tags() ) );

        return tour;
    }

    protected CityDTO cityToCityDTO(City city) {
        if ( city == null ) {
            return null;
        }

        String name = null;

        name = city.getName();

        CityDTO cityDTO = new CityDTO( name );

        return cityDTO;
    }

    protected TagResponseDTO tagToTagResponseDTO(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        String name = null;

        name = tag.getName();

        TagResponseDTO tagResponseDTO = new TagResponseDTO( name );

        return tagResponseDTO;
    }

    protected List<TagResponseDTO> tagSetToTagResponseDTOList(Set<Tag> set) {
        if ( set == null ) {
            return null;
        }

        List<TagResponseDTO> list = new ArrayList<TagResponseDTO>( set.size() );
        for ( Tag tag : set ) {
            list.add( tagToTagResponseDTO( tag ) );
        }

        return list;
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

    protected Theme themeDTOToTheme(ThemeDTO themeDTO) {
        if ( themeDTO == null ) {
            return null;
        }

        Theme theme = new Theme();

        theme.setName( themeDTO.name() );

        return theme;
    }

    protected City cityDTOToCity(CityDTO cityDTO) {
        if ( cityDTO == null ) {
            return null;
        }

        City city = new City();

        city.setName( cityDTO.name() );

        return city;
    }

    protected Tag tagResponseDTOToTag(TagResponseDTO tagResponseDTO) {
        if ( tagResponseDTO == null ) {
            return null;
        }

        Tag tag = new Tag();

        tag.setName( tagResponseDTO.name() );

        return tag;
    }

    protected Set<Tag> tagResponseDTOListToTagSet(List<TagResponseDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<Tag> set = new LinkedHashSet<Tag>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( TagResponseDTO tagResponseDTO : list ) {
            set.add( tagResponseDTOToTag( tagResponseDTO ) );
        }

        return set;
    }
}
