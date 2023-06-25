package mapper;

import domain.PlatformUser;
import dto.PlatformUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlatformUserDTOMapper {
    PlatformUserDTOMapper INSTANCE = Mappers.getMapper(PlatformUserDTOMapper.class);

    PlatformUserDTO convert(PlatformUser platformUser);
}
