package mapper;

import domain.Tour;
import domain.softdeletable.SoftDelete;
import dto.TourResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import value.Status;

import java.util.List;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface TourResponseDTOMapper {
    TourResponseDTOMapper INSTANCE = Mappers.getMapper(TourResponseDTOMapper.class);

    @Mapping(source = "softDelete.status", target = "status")
    TourResponseDTO convert(Tour tour);

    List<TourResponseDTO> convert(List<Tour> tours);

    default Status map(SoftDelete softDelete) {
        return softDelete != null ? softDelete.getStatus() : null;
    }
}
