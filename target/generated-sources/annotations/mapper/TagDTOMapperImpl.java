package mapper;

import domain.Tag;
import dto.TagRequestDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T08:37:49+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TagDTOMapperImpl implements TagDTOMapper {

    @Override
    public void updateTagFromDto(TagRequestDTO tagRequestDTO, Tag tag) {
        if ( tagRequestDTO == null ) {
            return;
        }

        tag.setId( tagRequestDTO.id() );
        tag.setName( tagRequestDTO.name() );
    }

    @Override
    public Tag convert(TagRequestDTO tagRequestDTO) {
        if ( tagRequestDTO == null ) {
            return null;
        }

        Tag tag = new Tag();

        tag.setId( tagRequestDTO.id() );
        tag.setName( tagRequestDTO.name() );

        return tag;
    }

    @Override
    public TagRequestDTO convert(Tag tag) {
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
}
