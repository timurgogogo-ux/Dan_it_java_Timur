package java_core_hw_7;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

public class PetTest {

    @Test
    void testToStringContainsNicknameAndSpecies() {
        Dog dog = new Dog("Rex", 5, 70, new HashSet<>(java.util.Arrays.asList("run")));
        String result = dog.toString();
        assertTrue(result.contains("Rex"));
        assertTrue(result.contains("DOG"));
    }

    @Test
    void testEatDoesNotThrow() {
        Dog dog = new Dog("Rex", 5, 70, new HashSet<>(java.util.Arrays.asList("run")));
        assertDoesNotThrow(dog::eat);
    }

    @Test
    void testRespondDoesNotThrow() {
        Dog dog = new Dog("Rex", 5, 70, new HashSet<>(java.util.Arrays.asList("run")));
        assertDoesNotThrow(dog::respond);
    }
}