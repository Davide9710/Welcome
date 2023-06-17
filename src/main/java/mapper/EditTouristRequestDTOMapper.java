package mapper;

import domain.Tourist;
import dto.EditTouristRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EditTouristRequestDTOMapper {
    EditTouristRequestDTOMapper INSTANCE = Mappers.getMapper(EditTouristRequestDTOMapper.class);

    Tourist updateTouristFromDto(EditTouristRequestDTO editTouristRequestDTO, @MappingTarget Tourist tourist);
}
