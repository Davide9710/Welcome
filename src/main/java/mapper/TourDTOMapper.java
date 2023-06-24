package mapper;

import domain.Tour;
import dto.TourDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface TourDTOMapper {
    TourDTOMapper INSTANCE = Mappers.getMapper(TourDTOMapper.class);

    Tour convert(TourDTO tourDTO);

    TourDTO convert(Tour tour);

    List<TourDTO> convert(List<Tour> tours);
}
