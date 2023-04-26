package mapper;

import domain.Tour;
import dto.TourResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TourResponseDTOMapper {
    TourResponseDTOMapper INSTANCE = Mappers.getMapper(TourResponseDTOMapper.class);

    TourResponseDTO convert(Tour tour);

    List<TourResponseDTO> convert(List<Tour> tours);
}
