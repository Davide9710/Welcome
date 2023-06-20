package mapper;

import domain.User;
import dto.AuthenticationResponseJwtDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthenticationResponseJwtDTOMapper {
    AuthenticationResponseJwtDTOMapper INSTANCE = Mappers.getMapper(AuthenticationResponseJwtDTOMapper.class);

    AuthenticationResponseJwtDTO convert(String jwt, User user);
}
