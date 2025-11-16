package java_core_hw_7;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

public class DogTest {

    @Test
    void testRespondAndFoulDoesNotThrow() {
        Dog dog = new Dog("Rex", 5, 70, new HashSet<>(java.util.Arrays.asList("run")));
        assertDoesNotThrow(dog::respond);
        assertDoesNotThrow(dog::foul);
    }
}