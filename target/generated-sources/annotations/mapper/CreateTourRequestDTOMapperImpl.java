package mapper;

import domain.Tour;
import dto.CreateTourRequestDTO;
import dto.TagDTO;
import dto.ThemeDTO;
import dto.TourStopDTO;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-09T17:34:01+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class CreateTourRequestDTOMapperImpl implements CreateTourRequestDTOMapper {

    @Override
    public CreateTourRequestDTO convert(Tour tour) {
        if ( tour == null ) {
            return null;
        }

        String title = null;
        Long cityId = null;
        ThemeDTO theme = null;
        List<TagDTO> tags = null;
        String approxDuration = null;
        Double approxCost = null;
        List<TourStopDTO> stops = null;

        CreateTourRequestDTO createTourRequestDTO = new CreateTourRequestDTO( title, cityId, theme, tags, approxDuration, approxCost, stops );

        return createTourRequestDTO;
    }

    @Override
    public Tour convert(CreateTourRequestDTO createTourRequestDTO) {
        if ( createTourRequestDTO == null ) {
            return null;
        }

        Tour tour = new Tour();

        return tour;
    }
}
