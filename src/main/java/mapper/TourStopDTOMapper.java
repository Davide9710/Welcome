package mapper;

import domain.Image;
import domain.TourStop;
import dto.ImageDTO;
import dto.TourStopDTO;
import org.apache.commons.lang3.ArrayUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Base64;
import java.util.List;

@Mapper
public interface TourStopDTOMapper {
    TourStopDTOMapper INSTANCE = Mappers.getMapper(TourStopDTOMapper.class);

    TourStop convert(TourStopDTO tourStopDTO);

    TourStopDTO convert(TourStop tourStop);

    List<TourStopDTO> convert(List<TourStopDTO> tourStop);

    default ImageDTO convert(Image image){
        Byte[] value = image.getImage();
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] valueConverted = ArrayUtils.toPrimitive(value);
        return new ImageDTO(encoder.encodeToString(valueConverted));
    }

    default Image convert(ImageDTO dto){
        Base64.Decoder decoder = Base64.getDecoder();
        String[] split = dto.image().split(",");
        String image64 = split[0];
        byte[] decode = decoder.decode(image64);
        Image image = new Image();
        image.setImage(ArrayUtils.toObject(decode));
        return image;
    }
}
