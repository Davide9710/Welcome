package mapper;

import domain.User;
import dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserDTOMapper {
    UserDTOMapper INSTANCE = Mappers.getMapper(UserDTOMapper.class);

    List<UserDTO> convert(List<User> users);

    UserDTO convert(User user);
}
