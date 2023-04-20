package mapper;

import domain.City;
import domain.Theme;
import domain.Tour;
import domain.Tour.TourStatus;
import dto.CityDTO;
import dto.CreateTourResponseDTO;
import dto.TagResponseDTO;
import dto.ThemeDTO;
import java.time.Instant;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T16:21:55+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
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
        TourStatus tourStatus = null;
        Instant creationTime = null;
        Instant lastUpdate = null;
        CityDTO city = null;
        ThemeDTO theme = null;

        title = tour.getTitle();
        approxCost = tour.getApproxCost();
        approxDuration = tour.getApproxDuration();
        tourStatus = tour.getTourStatus();
        creationTime = tour.getCreationTime();
        lastUpdate = tour.getLastUpdate();
        city = cityToCityDTO( tour.getCity() );
        theme = themeToThemeDTO( tour.getTheme() );

        List<TagResponseDTO> tags = null;

        CreateTourResponseDTO createTourResponseDTO = new CreateTourResponseDTO( title, approxCost, approxDuration, tourStatus, creationTime, lastUpdate, city, tags, theme );

        return createTourResponseDTO;
    }

    @Override
    public Tour convert(CreateTourResponseDTO createTourResponseDTO) {
        if ( createTourResponseDTO == null ) {
            return null;
        }

        Tour tour = new Tour();

        tour.setTourStatus( createTourResponseDTO.tourStatus() );
        tour.setTitle( createTourResponseDTO.title() );
        tour.setApproxCost( createTourResponseDTO.approxCost() );
        tour.setApproxDuration( createTourResponseDTO.approxDuration() );
        tour.setCreationTime( createTourResponseDTO.creationTime() );
        tour.setLastUpdate( createTourResponseDTO.lastUpdate() );
        tour.setCity( cityDTOToCity( createTourResponseDTO.city() ) );
        tour.setTheme( themeDTOToTheme( createTourResponseDTO.theme() ) );

        return tour;
    }

    protected CityDTO cityToCityDTO(City city) {
        if ( city == null ) {
            return null;
        }

        String name = null;

        name = city.getName();

        CityDTO cityDTO = new CityDTO( name );

        return cityDTO;
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

    protected City cityDTOToCity(CityDTO cityDTO) {
        if ( cityDTO == null ) {
            return null;
        }

        City city = new City();

        city.setName( cityDTO.name() );

        return city;
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
