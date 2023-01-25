package mapper;

import domain.Tour;
import dto.EditTourResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EditTourResponseDTOMapper {
    EditTourResponseDTOMapper INSTANCE = Mappers.getMapper(EditTourResponseDTOMapper.class);

    EditTourResponseDTO convert(Tour tour);

    Tour convert(EditTourResponseDTO editTourResponseDTO);
}
