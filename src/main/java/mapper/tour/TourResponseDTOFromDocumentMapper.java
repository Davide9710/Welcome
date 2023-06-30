package mapper.tour;

import domain.elastic.TourDocument;
import dto.response.TourResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TourResponseDTOFromDocumentMapper {
    TourResponseDTOFromDocumentMapper INSTANCE = Mappers.getMapper(TourResponseDTOFromDocumentMapper.class);

    List<TourResponseDTO> convert(List<TourDocument> documents);

    TourResponseDTO convert(TourDocument documents);
}
