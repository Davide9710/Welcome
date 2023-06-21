package mapper;

import dto.AuthenticationResponseJwtDTO;
import dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper
public interface AuthenticationResponseJwtDTOMapper {
    AuthenticationResponseJwtDTOMapper INSTANCE = Mappers.getMapper(AuthenticationResponseJwtDTOMapper.class);

    default AuthenticationResponseJwtDTO convert(String jwt, UserDetails user){
        return new AuthenticationResponseJwtDTO(jwt, new UserDTO(user.getUsername()));
    }
}
