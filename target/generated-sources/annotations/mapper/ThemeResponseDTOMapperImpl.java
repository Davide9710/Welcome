package mapper;

import domain.Theme;
import dto.ThemeResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T08:37:49+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ThemeResponseDTOMapperImpl implements ThemeResponseDTOMapper {

    @Override
    public List<ThemeResponseDTO> convert(List<Theme> themes) {
        if ( themes == null ) {
            return null;
        }

        List<ThemeResponseDTO> list = new ArrayList<ThemeResponseDTO>( themes.size() );
        for ( Theme theme : themes ) {
            list.add( themeToThemeResponseDTO( theme ) );
        }

        return list;
    }

    protected ThemeResponseDTO themeToThemeResponseDTO(Theme theme) {
        if ( theme == null ) {
            return null;
        }

        String name = null;

        name = theme.getName();

        ThemeResponseDTO themeResponseDTO = new ThemeResponseDTO( name );

        return themeResponseDTO;
    }
}
