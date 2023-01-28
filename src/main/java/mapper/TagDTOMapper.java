package mapper;

import domain.Tag;
import dto.TagDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface TagDTOMapper {
    void updateTagFromDto(TagDTO tagDTO, @MappingTarget Tag tag);
}
