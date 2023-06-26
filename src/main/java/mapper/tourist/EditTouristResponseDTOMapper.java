package mapper.tourist;

import domain.Tourist;
import dto.response.EditTouristResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface EditTouristResponseDTOMapper {
    EditTouristResponseDTOMapper INSTANCE = Mappers.getMapper(EditTouristResponseDTOMapper.class);

    EditTouristResponseDTO convert(Tourist tourist);
}
