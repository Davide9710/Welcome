package mapper;

import domain.Image;
import domain.Tour;
import dto.CreateTourRequestDTO;
import dto.ImageDTO;
import org.apache.commons.lang3.ArrayUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Base64;

@Mapper
public interface CreateTourRequestDTOMapper {
    CreateTourRequestDTOMapper INSTANCE = Mappers.getMapper(CreateTourRequestDTOMapper.class);

    CreateTourRequestDTO convert(Tour tour);

    Tour convert(CreateTourRequestDTO createTourRequestDTO);

    default ImageDTO convert(Image image){
        Byte[] value = image.getImage();
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] valueConverted = ArrayUtils.toPrimitive(value);
        return new ImageDTO(encoder.encodeToString(valueConverted));
    }

    default Image convert(ImageDTO dto){
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(dto.image());
        Image image = new Image();
        image.setImage(ArrayUtils.toObject(decode));
        return image;
    }
}
