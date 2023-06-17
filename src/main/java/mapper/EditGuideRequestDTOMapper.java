package mapper;

import domain.Guide;
import dto.EditGuideRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EditGuideRequestDTOMapper {
    EditGuideRequestDTOMapper INSTANCE = Mappers.getMapper(EditGuideRequestDTOMapper.class);

    Guide updateGuideFromDto(EditGuideRequestDTO editGuideRequestDTO, @MappingTarget Guide guide);
}
