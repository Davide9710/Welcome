package mapper;

import domain.Tag;
import dto.TagListResponseDTO;
import dto.TagResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TagResponseDTOMapper {
    TagResponseDTOMapper INSTANCE = Mappers.getMapper(TagResponseDTOMapper.class);

    List<TagResponseDTO> convert(List<Tag> tag);
}
