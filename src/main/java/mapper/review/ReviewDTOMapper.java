package mapper.review;

import domain.Review;
import dto.ReviewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface ReviewDTOMapper {
    ReviewDTOMapper INSTANCE = Mappers.getMapper(ReviewDTOMapper.class);

    ReviewDTO convert(Review review);
}
