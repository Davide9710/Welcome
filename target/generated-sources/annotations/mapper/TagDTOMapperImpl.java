package mapper;

import domain.Tag;
import dto.TagDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-09T17:34:02+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TagDTOMapperImpl implements TagDTOMapper {

    @Override
    public void updateTagFromDto(TagDTO tagDTO, Tag tag) {
        if ( tagDTO == null ) {
            return;
        }
    }
}
