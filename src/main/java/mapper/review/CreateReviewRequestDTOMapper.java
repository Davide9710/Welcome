package mapper.review;

import domain.Review;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface CreateReviewRequestDTOMapper {
    CreateReviewRequestDTOMapper INSTANCE = Mappers.getMapper(CreateReviewRequestDTOMapper.class);

    Review convert(String title,
                   Double stars,
                   String content);
}
