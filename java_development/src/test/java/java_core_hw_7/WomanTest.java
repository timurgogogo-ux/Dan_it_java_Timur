package java_core_hw_7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WomanTest {
    @Test
    void testWomanMethodsDoNotThrow() {
        Woman woman = new Woman("Anna", "Smith", 1985, 95, null);
        assertDoesNotThrow(woman::makeup);
        assertDoesNotThrow(woman::greetPet);
    }
}