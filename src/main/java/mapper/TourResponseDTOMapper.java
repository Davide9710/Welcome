package mapper;

import domain.Tour;
import dto.TourResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TourResponseDTOMapper {
    TourResponseDTOMapper INSTANCE = Mappers.getMapper(TourResponseDTOMapper.class);

    Tour convert(TourResponseDTO tourDTO);

    TourResponseDTO convert(Tour tour);

}
