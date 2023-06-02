package mapper;


import domain.Theme;
import dto.ThemeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ThemeResponseDTOMapper {
    ThemeResponseDTOMapper INSTANCE = Mappers.getMapper(ThemeResponseDTOMapper.class);

    List<ThemeResponseDTO> convert(List<Theme> themes);
}
