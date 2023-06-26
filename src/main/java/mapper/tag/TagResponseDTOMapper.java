package mapper.tag;

import domain.Tag;
import dto.response.TagResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface TagResponseDTOMapper {
    TagResponseDTOMapper INSTANCE = Mappers.getMapper(TagResponseDTOMapper.class);

    List<TagResponseDTO> convert(List<Tag> tag);
}
