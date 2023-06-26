package mapper.tag;

import domain.Tag;
import dto.request.TagRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface TagDTOMapper {
    TagDTOMapper INSTANCE = Mappers.getMapper(TagDTOMapper.class);

    void updateTagFromDto(TagRequestDTO tagRequestDTO, @MappingTarget Tag tag);

    Tag convert(TagRequestDTO tagRequestDTO);

    TagRequestDTO convert(Tag tag);

}
