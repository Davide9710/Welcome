package mapper;

import domain.Tour;
import dto.CreateTourResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface CreateTourResponseDTOMapper {
    CreateTourResponseDTOMapper INSTANCE = Mappers.getMapper(CreateTourResponseDTOMapper.class);

    CreateTourResponseDTO convert(Tour tour);

    Tour convert(CreateTourResponseDTO createTourResponseDTO);

}
