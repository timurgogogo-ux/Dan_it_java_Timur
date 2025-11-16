package java_core_hw_7;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

public class FishTest {

    @Test
    void testRespondDoesNotThrow() {
        Fish fish = new Fish("Goldie", 2, 50, new HashSet<>(java.util.Arrays.asList("swim")));
        assertDoesNotThrow(fish::respond);
    }
}