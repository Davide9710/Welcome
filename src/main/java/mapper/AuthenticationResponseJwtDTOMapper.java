package mapper;

import dto.AuthenticationResponseJwtDTO;
import dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface AuthenticationResponseJwtDTOMapper {
    AuthenticationResponseJwtDTOMapper INSTANCE = Mappers.getMapper(AuthenticationResponseJwtDTOMapper.class);

    /**
     * Method custom convert the data into a AuthenticationResponseJwtDTO; it also adapts the UserDetails specific
     * Spring class into a UserDTO record
     * @param jwt auth token
     * @param user spring boot user details
     * @return it returns the token and the user's email
     */
    default AuthenticationResponseJwtDTO convert(String jwt, UserDetails user){
        return new AuthenticationResponseJwtDTO(jwt, new UserDTO(user.getUsername()));
    }
}
