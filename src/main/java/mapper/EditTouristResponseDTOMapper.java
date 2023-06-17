package mapper;

import domain.Tourist;
import dto.EditTouristResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EditTouristResponseDTOMapper {
    EditTouristResponseDTOMapper INSTANCE = Mappers.getMapper(EditTouristResponseDTOMapper.class);

    EditTouristResponseDTO convert(Tourist tourist);
}
