package mapper;

import domain.Guide;
import dto.EditGuideResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface EditGuideResponseDTOMapper {
    EditGuideResponseDTOMapper INSTANCE = Mappers.getMapper(EditGuideResponseDTOMapper.class);

    EditGuideResponseDTO convert(Guide guide);
}
