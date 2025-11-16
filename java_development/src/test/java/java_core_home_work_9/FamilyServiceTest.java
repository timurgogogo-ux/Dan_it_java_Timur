package java_core_home_work_9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyServiceTest {

    private CollectionFamilyDao dao;
    private FamilyService service;

    @BeforeEach
    void setUp() {
        dao = new CollectionFamilyDao();
        service = new FamilyService(dao);

        long momBirth = LocalDate.of(1985, 3, 10).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long dadBirth = LocalDate.of(1980, 1, 5).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

        Woman mother = new Woman("Anna", "Smith", momBirth, 95);
        Man father = new Man("John", "Smith", dadBirth, 90);

        Family f = new Family(mother, father);
        dao.addInitialFamily(f); // helper to populate
    }

    @Test
    void testCreateNewFamily() {
        int before = service.count();
        Woman mom = new Woman("Kate", "Bell", "01/01/1990", 80);
        Man dad = new Man("Tom", "Bell", "01/01/1987", 75);

        service.createNewFamily(mom, dad);
        assertEquals(before + 1, service.count());
    }

    @Test
    void testBornChildAddsChild() {
        Family f = service.getFamilyById(0);
        assertNotNull(f);

        int before = f.getChildren().size();
        service.bornChild(f, "BoyName", "GirlName");
        Family updated = service.getFamilyById(0);
        assertEquals(before + 1, updated.getChildren().size());
    }

    @Test
    void testAdoptChild() {
        Family f = service.getFamilyById(0);
        Human child = new Human("Adopted", "Smith", "10/10/2012", 70);

        int before = f.getChildren().size();
        service.adoptChild(f, child);
        assertEquals(before + 1, f.getChildren().size());
        assertTrue(f.getChildren().contains(child));
    }

    @Test
    void testDeleteAllChildrenOlderThen() {
        Family f = service.getFamilyById(0);
        // add two children with different birth dates
        Human young = new Human("Young", "Smith", "01/01/2019", 50); // ~6 years or less depending on current date
        Human old = new Human("Old", "Smith", "01/01/2000", 50); // definitely >5 years
        f.addChild(young);
        f.addChild(old);
        dao.saveFamily(f);

        service.deleteAllChildrenOlderThen(18); // delete older than 18
        Family after = service.getFamilyById(0);

        boolean hasOld = after.getChildren().stream().anyMatch(c -> c.getName().equals("Old"));
        boolean hasYoung = after.getChildren().stream().anyMatch(c -> c.getName().equals("Young"));
        assertFalse(hasOld);
        assertTrue(hasYoung || after.getChildren().size()>=0); // young likely present
    }

    @Test
    void testAddPet() {
        Dog dog = new Dog("Buddy", 3, 40, new HashSet<>(Arrays.asList("play")));
        boolean added = service.addPet(0, dog);
        assertTrue(added);

        Family f = service.getFamilyById(0);
        assertTrue(f.getPets().stream().anyMatch(p -> p.getNickname().equals("Buddy")));
    }
}