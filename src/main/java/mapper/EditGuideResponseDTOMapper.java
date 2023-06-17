package mapper;

import domain.Guide;
import dto.EditGuideResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EditGuideResponseDTOMapper {
    EditGuideResponseDTOMapper INSTANCE = Mappers.getMapper(EditGuideResponseDTOMapper.class);

    EditGuideResponseDTO convert(Guide guide);
}
