package java_core_home_work_9;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java_core_home_work_9.*;
import java_core_home_work_9.dao.CollectionFamilyDao;
import java_core_home_work_9.dao.FamilyDao;

public class FamilyServiceTest {

    private FamilyService service;
    private FamilyDao dao;

    @BeforeEach
    public void setup() {
        dao = new CollectionFamilyDao();
        service = new FamilyService(dao);

        long mBirth = LocalDate.of(1985, 3, 10).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long fBirth = LocalDate.of(1980, 1, 5).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

        Woman m = new Woman("Anna", "Test", mBirth, 90);
        Man f = new Man("John", "Test", fBirth, 90);

        service.createNewFamily(m, f);
    }

    @Test
    public void testCreateAndCount() {
        assertEquals(1, service.count());
        List<Family> families = service.getAllFamilies();
        assertNotNull(families);
        assertEquals(1, families.size());
    }

    @Test
    public void testAddPetAndGetPets() {
        Dog dog = new Dog("Buddy", 2, 50, new HashSet<>());
        service.addPet(0, dog);
        assertTrue(service.getPets(0).contains(dog));
    }

    @Test
    public void testAdoptChild() {
        Human child = new Human("Sam", "Test", "01/01/2018", 60);
        Family f = service.getFamilyById(0);
        service.adoptChild(f, child);
        assertTrue(f.getChildren().contains(child));
    }

    @Test
    public void testBornChild() {
        Family f = service.getFamilyById(0);
        int before = f.getChildren().size();
        service.bornChild(f, "Ben", "Anna");
        assertEquals(before + 1, f.getChildren().size());
    }

    @Test
    public void testDeleteAllChildrenOlderThen() {
        Family f = service.getFamilyById(0);
        // create a child older than 10 years
        Human oldChild = new Human("Old", "Test", "01/01/2000", 50);
        service.adoptChild(f, oldChild);
        service.deleteAllChildrenOlderThen(18);
        assertFalse(f.getChildren().contains(oldChild));
    }

    @Test
    public void testGetFamiliesBiggerLessThanCount() {
        // After setup there's 1 family and maybe no children/pets.
        assertEquals(0, service.getFamiliesBiggerThan(3).size());
        assertTrue(service.getFamiliesLessThan(5).size() >= 1);
        // count families with member number 2 (just parents)
        assertTrue(service.countFamiliesWithMemberNumber(2) >= 1);
    }

    @Test
    public void testDeleteFamilyByIndex() {
        assertTrue(service.deleteFamilyByIndex(0));
        assertEquals(0, service.count());
    }
}