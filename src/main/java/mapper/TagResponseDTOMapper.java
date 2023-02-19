package mapper;

import domain.Tag;
import dto.TagListResponseDTO;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface TagResponseDTOMapper {
    TagResponseDTOMapper INSTANCE = Mappers.getMapper(TagResponseDTOMapper.class);

    List<Tag> convert(TagListResponseDTO tagListResponseDTO);

    TagListResponseDTO convert(List<Tag> tag);
}
