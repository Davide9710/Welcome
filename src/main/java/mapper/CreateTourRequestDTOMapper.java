package mapper;

import domain.Image;
import domain.Tour;
import dto.CreateTourRequestDTO;
import org.apache.commons.lang3.ArrayUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Base64;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface CreateTourRequestDTOMapper {
    CreateTourRequestDTOMapper INSTANCE = Mappers.getMapper(CreateTourRequestDTOMapper.class);

    CreateTourRequestDTO convert(Tour tour);

    Tour convert(CreateTourRequestDTO createTourRequestDTO);

    default String convert(Image image){
        Byte[] value = image.getImage();
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] valueConverted = ArrayUtils.toPrimitive(value);
        return encoder.encodeToString(valueConverted);
    }

    default Image convert(String dto){
        Base64.Decoder decoder = Base64.getDecoder();
        String[] split = dto.split(",");
        String image64 = split[1];
        byte[] decode = decoder.decode(image64);
        Image image = new Image();
        image.setImage(ArrayUtils.toObject(decode));
        return image;
    }
}
