package mapper;

import domain.Review;
import dto.ReviewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewDTOMapper {
    ReviewDTOMapper INSTANCE = Mappers.getMapper(ReviewDTOMapper.class);

    ReviewDTO convert(Review review);
}
