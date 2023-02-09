package mapper;

import domain.Tour;
import dto.EditTourRequestDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-09T17:34:02+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EditTourRequestDTOMapperImpl implements EditTourRequestDTOMapper {

    @Override
    public Tour updateTourFromDto(EditTourRequestDTO editTourRequestDTO, Tour tour) {
        if ( editTourRequestDTO == null ) {
            return null;
        }

        return tour;
    }
}
