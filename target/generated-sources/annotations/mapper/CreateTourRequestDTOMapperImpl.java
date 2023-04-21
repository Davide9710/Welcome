package mapper;

import domain.Tag;
import domain.Theme;
import domain.Tour;
import dto.CityRequestDTO;
import dto.CreateTourRequestDTO;
import dto.TagRequestDTO;
import dto.ThemeDTO;
import dto.TourStopDTO;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T17:14:19+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
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

        title = tour.getTitle();
        theme = themeToThemeDTO( tour.getTheme() );
        tags = tagSetToTagRequestDTOList( tour.getTags() );
        approxDuration = tour.getApproxDuration();
        approxCost = tour.getApproxCost();

        CityRequestDTO cityRequestDTO = null;
        List<TourStopDTO> stops = null;

        CreateTourRequestDTO createTourRequestDTO = new CreateTourRequestDTO( title, cityRequestDTO, theme, tags, approxDuration, approxCost, stops );

        return createTourRequestDTO;
    }

    @Override
    public Tour convert(CreateTourRequestDTO createTourRequestDTO) {
        if ( createTourRequestDTO == null ) {
            return null;
        }

        Tour tour = new Tour();

        tour.setTheme( themeDTOToTheme( createTourRequestDTO.theme() ) );
        tour.setTitle( createTourRequestDTO.title() );
        tour.setApproxCost( createTourRequestDTO.approxCost() );
        tour.setApproxDuration( createTourRequestDTO.approxDuration() );
        tour.setTags( tagRequestDTOListToTagSet( createTourRequestDTO.tags() ) );

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

    protected List<TagRequestDTO> tagSetToTagRequestDTOList(Set<Tag> set) {
        if ( set == null ) {
            return null;
        }

        List<TagRequestDTO> list = new ArrayList<TagRequestDTO>( set.size() );
        for ( Tag tag : set ) {
            list.add( tagToTagRequestDTO( tag ) );
        }

        return list;
    }

    protected Theme themeDTOToTheme(ThemeDTO themeDTO) {
        if ( themeDTO == null ) {
            return null;
        }

        Theme theme = new Theme();

        theme.setName( themeDTO.name() );

        return theme;
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

    protected Set<Tag> tagRequestDTOListToTagSet(List<TagRequestDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<Tag> set = new LinkedHashSet<Tag>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( TagRequestDTO tagRequestDTO : list ) {
            set.add( tagRequestDTOToTag( tagRequestDTO ) );
        }

        return set;
    }
}
