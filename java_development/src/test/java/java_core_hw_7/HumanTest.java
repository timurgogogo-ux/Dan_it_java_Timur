package java_core_hw_7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class HumanTest {
    private Human human;
    private Family family;

    @BeforeEach
    void setup() {
        human = new Human("Mike", "Smith", 2010, 80);
        family = new Family(
                new Woman("Anna", "Smith", 1985, 90, null),
                new Man("John", "Smith", 1980, 95, null)
        );
        human.setFamily(family);
    }

    @Test
    void testGreetPetDoesNotThrow() {
        Dog dog = new Dog("Rex", 5, 70, new HashSet<>(Set.of("run")));
        family.setPets(new HashSet<>(Set.of(dog)));

        assertDoesNotThrow(() -> human.greetPet());
    }

    @Test
    void testSetAndGetFamily() {
        assertEquals(family, human.getFamily());
    }
}