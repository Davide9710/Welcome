package mapper;

import domain.Tour;
import dto.CreateTourRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreateTourRequestDTOMapper {
    CreateTourRequestDTOMapper INSTANCE = Mappers.getMapper(CreateTourRequestDTOMapper.class);

    CreateTourRequestDTO convert(Tour tour);

    Tour convert(CreateTourRequestDTO createTourRequestDTO);
}
