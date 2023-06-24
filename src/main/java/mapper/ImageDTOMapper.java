package mapper;

import domain.Image;
import dto.ImageDTO;
import org.apache.commons.lang3.ArrayUtils;
import org.mapstruct.Mapper;

import java.util.Base64;

/**
 * Mapstruct mapper used as a singleton pattern, specifically "Initialization-on-demand holder idiom" design pattern
 * that allows lazy loaded singleton instance
 */
@Mapper
public interface ImageDTOMapper {

    /**
     * Utility converter that convert an image Byte[] into a String image
     * @param image the entity from the db
     * @return the image in string format
     */
    default ImageDTO convert(Image image){
        Byte[] value = image.getImage();
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] valueConverted = ArrayUtils.toPrimitive(value);
        return new ImageDTO(encoder.encodeToString(valueConverted));
    }

    /**
     * Utility converter that convert a String image into an image Byte[]
     * @param dto the image in string format
     * @return an image object
     */
    default Image convert(ImageDTO dto){
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(dto.image());
        Image image = new Image();
        image.setImage(ArrayUtils.toObject(decode));
        return image;
    }
}
