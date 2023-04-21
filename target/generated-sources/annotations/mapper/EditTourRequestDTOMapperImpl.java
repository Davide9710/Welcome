package mapper;

import domain.Tour;
import dto.EditTourRequestDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T17:00:02+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EditTourRequestDTOMapperImpl implements EditTourRequestDTOMapper {

    @Override
    public Tour updateTourFromDto(EditTourRequestDTO editTourRequestDTO, Tour tour) {
        if ( editTourRequestDTO == null ) {
            return tour;
        }

        return tour;
    }
}
