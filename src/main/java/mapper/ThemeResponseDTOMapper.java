package mapper;

import domain.Theme;
import dto.ThemeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface ThemeResponseDTOMapper {
    ThemeResponseDTOMapper INSTANCE = Mappers.getMapper(ThemeResponseDTOMapper.class);

    List<ThemeResponseDTO> convert(List<Theme> themes);
}
