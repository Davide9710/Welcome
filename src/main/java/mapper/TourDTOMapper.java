package mapper;

import domain.Tour;
import dto.TourDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TourDTOMapper {
    TourDTOMapper INSTANCE = Mappers.getMapper(TourDTOMapper.class);

    Tour convert(TourDTO tourDTO);

    TourDTO convert(Tour tour);

    List<TourDTO> convert(List<Tour> tours);
}
