package mapper;

import domain.Theme;
import domain.Tour;
import dto.CityDTO;
import dto.CreateTourResponseDTO;
import dto.TagResponseDTO;
import dto.ThemeDTO;
import java.time.Instant;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T17:00:02+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class CreateTourResponseDTOMapperImpl implements CreateTourResponseDTOMapper {

    @Override
    public CreateTourResponseDTO convert(Tour tour) {
        if ( tour == null ) {
            return null;
        }

        String title = null;
        Double approxCost = null;
        String approxDuration = null;
        Tour.TourStatus tourStatus = null;
        Instant creationTime = null;
        Instant lastUpdate = null;
        CityDTO city = null;
        List<TagResponseDTO> tags = null;
        ThemeDTO theme = null;

        CreateTourResponseDTO createTourResponseDTO = new CreateTourResponseDTO( title, approxCost, approxDuration, tourStatus, creationTime, lastUpdate, city, tags, theme );

        return createTourResponseDTO;
    }

    @Override
    public Tour convert(CreateTourResponseDTO createTourResponseDTO) {
        if ( createTourResponseDTO == null ) {
            return null;
        }

        Tour tour = new Tour();

        tour.setTheme( themeDTOToTheme( createTourResponseDTO.theme() ) );

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
