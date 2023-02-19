package mapper;

import domain.Tag;
import dto.TagRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface TagDTOMapper {
    void updateTagFromDto(TagRequestDTO tagRequestDTO, @MappingTarget Tag tag);
}
