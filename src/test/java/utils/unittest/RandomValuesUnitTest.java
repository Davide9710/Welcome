package utils.unittest;

import org.junit.jupiter.api.Test;
import utils.RandomValues;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomValuesUnitTest {
    @Test
    public void generateRandomStringTest(){
        assertTrue(RandomValues.generateRandomString().matches("^[a-zA-Z0-9]{10}$"));
    }
}
