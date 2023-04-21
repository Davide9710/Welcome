package mapper;

import domain.City;
import domain.Tag;
import domain.Tour;
import dto.CityDTO;
import dto.EditTourRequestDTO;
import dto.TagRequestDTO;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T17:14:19+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EditTourRequestDTOMapperImpl implements EditTourRequestDTOMapper {

    @Override
    public Tour updateTourFromDto(EditTourRequestDTO editTourRequestDTO, Tour tour) {
        if ( editTourRequestDTO == null ) {
            return tour;
        }

        tour.setTitle( editTourRequestDTO.title() );
        if ( editTourRequestDTO.city() != null ) {
            if ( tour.getCity() == null ) {
                tour.setCity( new City() );
            }
            cityDTOToCity( editTourRequestDTO.city(), tour.getCity() );
        }
        else {
            tour.setCity( null );
        }
        if ( tour.getTags() != null ) {
            Set<Tag> set = tagRequestDTOListToTagSet( editTourRequestDTO.tags() );
            if ( set != null ) {
                tour.getTags().clear();
                tour.getTags().addAll( set );
            }
            else {
                tour.setTags( null );
            }
        }
        else {
            Set<Tag> set = tagRequestDTOListToTagSet( editTourRequestDTO.tags() );
            if ( set != null ) {
                tour.setTags( set );
            }
        }

        return tour;
    }

    protected void cityDTOToCity(CityDTO cityDTO, City mappingTarget) {
        if ( cityDTO == null ) {
            return;
        }

        mappingTarget.setName( cityDTO.name() );
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
