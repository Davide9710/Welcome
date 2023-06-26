package mapper;

import domain.Tour;
import dto.EditTourRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface EditTourRequestDTOMapper {
    EditTourRequestDTOMapper INSTANCE = Mappers.getMapper(EditTourRequestDTOMapper.class);

    Tour updateTourFromDto(EditTourRequestDTO editTourRequestDTO, @MappingTarget Tour tour);
}
