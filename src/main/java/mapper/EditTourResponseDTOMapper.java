package mapper;

import domain.Tour;
import dto.EditTourResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface EditTourResponseDTOMapper {
    EditTourResponseDTOMapper INSTANCE = Mappers.getMapper(EditTourResponseDTOMapper.class);

    EditTourResponseDTO convert(Tour tour);

    Tour convert(EditTourResponseDTO editTourResponseDTO);
}
