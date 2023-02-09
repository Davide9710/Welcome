package mapper;

import domain.Tour;
import dto.CreateTourResponseDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-09T17:34:02+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class CreateTourResponseDTOMapperImpl implements CreateTourResponseDTOMapper {

    @Override
    public CreateTourResponseDTO convert(Tour tour) {
        if ( tour == null ) {
            return null;
        }

        CreateTourResponseDTO createTourResponseDTO = new CreateTourResponseDTO();

        return createTourResponseDTO;
    }

    @Override
    public Tour convert(CreateTourResponseDTO createTourResponseDTO) {
        if ( createTourResponseDTO == null ) {
            return null;
        }

        Tour tour = new Tour();

        return tour;
    }
}
