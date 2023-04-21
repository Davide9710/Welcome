package mapper;

import domain.Theme;
import domain.Tour;
import dto.CityRequestDTO;
import dto.CreateTourRequestDTO;
import dto.TagRequestDTO;
import dto.ThemeDTO;
import dto.TourStopDTO;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T17:00:02+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class CreateTourRequestDTOMapperImpl implements CreateTourRequestDTOMapper {

    @Override
    public CreateTourRequestDTO convert(Tour tour) {
        if ( tour == null ) {
            return null;
        }

        String title = null;
        CityRequestDTO cityRequestDTO = null;
        ThemeDTO theme = null;
        List<TagRequestDTO> tags = null;
        String approxDuration = null;
        Double approxCost = null;
        List<TourStopDTO> stops = null;

        CreateTourRequestDTO createTourRequestDTO = new CreateTourRequestDTO( title, cityRequestDTO, theme, tags, approxDuration, approxCost, stops );

        return createTourRequestDTO;
    }

    @Override
    public Tour convert(CreateTourRequestDTO createTourRequestDTO) {
        if ( createTourRequestDTO == null ) {
            return null;
        }

        Tour tour = new Tour();

        tour.setTheme( themeDTOToTheme( createTourRequestDTO.theme() ) );

        return tour;
    }

    protected Theme themeDTOToTheme(ThemeDTO themeDTO) {
        if ( themeDTO == null ) {
            return null;
        }

        Theme theme = new Theme();

        theme.setName( themeDTO.name() );

        return theme;
    }
}
