package mapper;

import domain.Tag;
import dto.TagRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TagDTOMapper {
    TagDTOMapper INSTANCE = Mappers.getMapper(TagDTOMapper.class);

    void updateTagFromDto(TagRequestDTO tagRequestDTO, @MappingTarget Tag tag);

    Tag convert(TagRequestDTO tagRequestDTO);

    TagRequestDTO convert(Tag tag);

}