package mapper;

import domain.Review;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreateReviewRequestDTOMapper {
    CreateReviewRequestDTOMapper INSTANCE = Mappers.getMapper(CreateReviewRequestDTOMapper.class);

    Review convert(String title,
                   Double stars,
                   String content);
}
