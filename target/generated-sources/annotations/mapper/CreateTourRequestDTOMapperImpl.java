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
    date = "2023-04-21T08:37:49+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class CreateTourRequestDTOMapperImpl implements CreateTourRequestDTOMapper {

    @Override
    public CreateTourRequestDTO convert(Tour tour) {
        if ( tour == null ) {
            return null;
        }

        String title = null;
        ThemeDTO theme = null;
        String approxDuration = null;
        Double approxCost = null;

        title = tour.getTitle();
        theme = themeToThemeDTO( tour.getTheme() );
        approxDuration = tour.getApproxDuration();
        approxCost = tour.getApproxCost();

        CityRequestDTO cityRequestDTO = null;
        List<TagRequestDTO> tags = null;
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

        tour.setTitle( createTourRequestDTO.title() );
        tour.setApproxCost( createTourRequestDTO.approxCost() );
        tour.setApproxDuration( createTourRequestDTO.approxDuration() );
        tour.setTheme( themeDTOToTheme( createTourRequestDTO.theme() ) );

        return tour;
    }

    protected ThemeDTO themeToThemeDTO(Theme theme) {
        if ( theme == null ) {
            return null;
        }

        String name = null;

        name = theme.getName();

        ThemeDTO themeDTO = new ThemeDTO( name );

        return themeDTO;
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
