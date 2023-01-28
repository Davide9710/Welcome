package mapper;

import domain.Tour;
import dto.EditTourRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EditTourRequestDTOMapper {
    EditTourRequestDTOMapper INSTANCE = Mappers.getMapper(EditTourRequestDTOMapper.class);

    Tour updateTourFromDto(EditTourRequestDTO editTourRequestDTO, @MappingTarget Tour tour);
}
