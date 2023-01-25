package mapper;

import domain.Tour;
import dto.CreateTourResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreateTourResponseDTOMapper {
    CreateTourResponseDTOMapper INSTANCE = Mappers.getMapper(CreateTourResponseDTOMapper.class);

    CreateTourResponseDTO convert(Tour tour);

    Tour convert(CreateTourResponseDTO createTourResponseDTO);

}
