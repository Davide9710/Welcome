package mapper;

import org.apache.commons.lang3.ArrayUtils;
import org.mapstruct.Mapper;

import java.util.Base64;

@Mapper
public interface ImageDTOMapper {
    default String map(Byte[] value){
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] valueConverted = ArrayUtils.toPrimitive(value);
        return encoder.encodeToString(valueConverted);
    }

    default Byte[] map(String value){
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(value);
        return ArrayUtils.toObject(decode);
    }
}
