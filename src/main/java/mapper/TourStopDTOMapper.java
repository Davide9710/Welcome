package mapper;

import domain.TourStop;
import dto.TourStopDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TourStopDTOMapper {
    TourStopDTOMapper INSTANCE = Mappers.getMapper(TourStopDTOMapper.class);

    TourStop convert(TourStopDTO tourStopDTO);

    TourStopDTO convert(TourStop tourStop);

    List<TourStopDTO> convert(List<TourStopDTO> tourStop);

}
