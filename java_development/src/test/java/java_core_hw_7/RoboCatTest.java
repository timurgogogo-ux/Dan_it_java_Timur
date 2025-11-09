package java_core_hw_7;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

public class DomesticCatTest {

    @Test
    void testRespondAndFoulDoesNotThrow() {
        DomesticCat cat = new DomesticCat("Murka", 3, 60, new HashSet<>(java.util.Arrays.asList("sleep")));
        assertDoesNotThrow(cat::respond);
        assertDoesNotThrow(cat::foul);
    }
}