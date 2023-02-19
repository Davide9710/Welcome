package mapper;


import domain.Theme;
import dto.ThemeListResponseDTO;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface ThemeResponseDTOMapper {
    ThemeResponseDTOMapper INSTANCE = Mappers.getMapper(ThemeResponseDTOMapper.class);

    List<Theme> convert(ThemeListResponseDTO themeListResponseDTO);

    ThemeListResponseDTO convert(List<Theme> themes);


}
