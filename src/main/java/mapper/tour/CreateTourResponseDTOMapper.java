package mapper.tour;

import domain.Tour;
import domain.softdeletable.SoftDelete;
import dto.response.CreateTourResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import value.Status;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface CreateTourResponseDTOMapper {
    CreateTourResponseDTOMapper INSTANCE = Mappers.getMapper(CreateTourResponseDTOMapper.class);

    @Mapping(source = "softDelete.status", target = "status")
    CreateTourResponseDTO convert(Tour tour);

    Tour convert(CreateTourResponseDTO createTourResponseDTO);

    default Status map(SoftDelete softDelete) {
        return softDelete != null ? softDelete.getStatus() : null;
    }

}
