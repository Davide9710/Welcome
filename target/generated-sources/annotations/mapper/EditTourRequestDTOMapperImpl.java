package mapper;

import domain.City;
import domain.Tag;
import domain.Tour;
import dto.CityDTO;
import dto.EditTourRequestDTO;
import dto.TagRequestDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-26T17:16:10+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EditTourRequestDTOMapperImpl implements EditTourRequestDTOMapper {

    @Override
    public Tour updateTourFromDto(EditTourRequestDTO editTourRequestDTO, Tour tour) {
        if ( editTourRequestDTO == null ) {
            return null;
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
            List<Tag> list = tagRequestDTOListToTagList( editTourRequestDTO.tags() );
            if ( list != null ) {
                tour.getTags().clear();
                tour.getTags().addAll( list );
            }
            else {
                tour.setTags( null );
            }
        }
        else {
            List<Tag> list = tagRequestDTOListToTagList( editTourRequestDTO.tags() );
            if ( list != null ) {
                tour.setTags( list );
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
}
