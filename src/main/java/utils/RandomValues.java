package utils;

import java.security.SecureRandom;
import java.util.stream.Collectors;

public class RandomValues {
    public static String generateRandomString() {
        int stringLength = 10;
        SecureRandom secureRandom = new SecureRandom();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        return secureRandom.ints(stringLength, 0, characters.length())
                .mapToObj(characters::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
