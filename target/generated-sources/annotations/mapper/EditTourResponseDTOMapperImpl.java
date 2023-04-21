package mapper;

import domain.Tour;
import dto.EditTourResponseDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T08:37:49+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EditTourResponseDTOMapperImpl implements EditTourResponseDTOMapper {

    @Override
    public EditTourResponseDTO convert(Tour tour) {
        if ( tour == null ) {
            return null;
        }

        EditTourResponseDTO editTourResponseDTO = new EditTourResponseDTO();

        return editTourResponseDTO;
    }

    @Override
    public Tour convert(EditTourResponseDTO editTourResponseDTO) {
        if ( editTourResponseDTO == null ) {
            return null;
        }

        Tour tour = new Tour();

        return tour;
    }
}
