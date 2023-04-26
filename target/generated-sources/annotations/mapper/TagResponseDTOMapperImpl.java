package mapper;

import domain.Tag;
import dto.TagResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-25T09:27:03+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TagResponseDTOMapperImpl implements TagResponseDTOMapper {

    @Override
    public List<TagResponseDTO> convert(List<Tag> tag) {
        if ( tag == null ) {
            return null;
        }

        List<TagResponseDTO> list = new ArrayList<TagResponseDTO>( tag.size() );
        for ( Tag tag1 : tag ) {
            list.add( tagToTagResponseDTO( tag1 ) );
        }

        return list;
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
}
