package java_core_hw_7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManTest {
    @Test
    void testManMethodsDoNotThrow() {
        Man man = new Man("John", "Smith", 1980, 90, null);
        assertDoesNotThrow(man::repairCar);
        assertDoesNotThrow(man::greetPet);
    }
}