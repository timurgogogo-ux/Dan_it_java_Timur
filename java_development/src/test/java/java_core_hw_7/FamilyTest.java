package java_core_hw_7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class FamilyTest {
    private Family family;
    private Human child;

    @BeforeEach
    void setup() {
        Woman mother = new Woman("Anna", "Smith", 1985, 95, null);
        Man father = new Man("John", "Smith", 1980, 90, null);
        family = new Family(mother, father);
        child = new Human("Mike", "Smith", 2010, 80);
    }

    @Test
    void testAddChildIncreasesCount() {
        int before = family.countFamily();
        family.addChild(child);
        int after = family.countFamily();
        assertEquals(before + 1, after);
        assertTrue(family.getChildren().contains(child));
    }

    @Test
    void testDeleteChildRemovesSuccessfully() {
        family.addChild(child);
        boolean removed = family.deleteChild(child);
        assertTrue(removed);
        assertFalse(family.getChildren().contains(child));
    }

    @Test
    void testCountFamilyIncludesParentsChildrenPets() {
        family.addChild(child);
        Dog dog = new Dog("Rex", 5, 70, Set.of("run"));
        family.setPets(new HashSet<>(Set.of(dog)));

        assertEquals(4, family.countFamily());
    }
}