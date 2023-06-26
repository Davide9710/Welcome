package mapper;

import domain.Tourist;
import dto.EditTouristRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface EditTouristRequestDTOMapper {
    EditTouristRequestDTOMapper INSTANCE = Mappers.getMapper(EditTouristRequestDTOMapper.class);

    Tourist updateTouristFromDto(EditTouristRequestDTO editTouristRequestDTO, @MappingTarget Tourist tourist);
}
