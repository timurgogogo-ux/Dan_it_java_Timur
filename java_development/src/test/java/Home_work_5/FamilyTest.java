package Home_work_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    private Family family;
    private Human mother;
    private Human father;
    private Human child1;
    private Human child2;

    @BeforeEach
    void setUp() {
        mother = new Human("Jane", "Karleone", 1979);
        father = new Human("Vito", "Karleone", 1977);
        family = new Family(mother, father);

        child1 = new Human("Michael", "Karleone", 2000);
        child2 = new Human("Connie", "Karleone", 2002);
        family.addChild(child1);
        family.addChild(child2);
    }

    @Test
    void testToStringContainsExpected() {
        String expectedStart = "Family{mother=Jane Karleone, father=Vito Karleone";
        String actual = family.toString();
        assertTrue(actual.startsWith(expectedStart), "toString should start with mother and father names");
    }

    @Test
    void deleteChildByObject_positive_removesChild() {
        int before = family.getChildren().length;
        boolean result = family.deleteChild(new Human("Michael", "Karleone", 2000));
        int after = family.getChildren().length;

        assertTrue(result, "deleteChild should return true when child exists");
        assertEquals(before - 1, after, "children array should decrease by one");
        // ensure remaining children do not contain the deleted child
        for (Human h : family.getChildren()) {
            assertNotEquals("Michael", h.getName());
        }
    }

    @Test
    void deleteChildByObject_negative_noChange() {
        int before = family.getChildren().length;
        boolean result = family.deleteChild(new Human("Noname", "Nobody", 1999));
        int after = family.getChildren().length;

        assertFalse(result, "deleteChild should return false when child doesn't exist");
        assertEquals(before, after, "children array should remain unchanged");
    }

    @Test
    void deleteChildByIndex_positive() {
        int before = family.getChildren().length;
        boolean result = family.deleteChild(0);
        int after = family.getChildren().length;

        assertTrue(result, "deleteChild(index) should return true for valid index");
        assertEquals(before - 1, after, "children array should decrease by one");
    }

    @Test
    void deleteChildByIndex_negative_outOfRange() {
        int before = family.getChildren().length;
        boolean result = family.deleteChild(100); // out of range
        int after = family.getChildren().length;

        assertFalse(result, "deleteChild(index) should return false for invalid index");
        assertEquals(before, after, "children array should remain unchanged");
    }

    @Test
    void addChild_increasesArrayAndSetsFamily() {
        Human newChild = new Human("Anna", "Karleone", 2010);
        int before = family.getChildren().length;
        family.addChild(newChild);
        int after = family.getChildren().length;

        assertEquals(before + 1, after, "children array should increase by 1 after addChild");
        Human[] children = family.getChildren();
        assertEquals(newChild, children[children.length - 1], "last child should be the added child");
        assertEquals(family, newChild.getFamily(), "child's family should be set to the family");
    }

    @Test
    void countFamily_returnsCorrectHumanCount() {
        int expected = 2 + family.getChildren().length;
        assertEquals(expected, family.countFamily());
    }
}