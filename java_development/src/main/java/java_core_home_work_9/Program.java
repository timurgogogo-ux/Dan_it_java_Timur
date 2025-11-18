package java_core_home_work_9;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.HashSet;

import java_core_home_work_9.FamilyController;
import java_core_home_work_9.CollectionFamilyDao;
import java_core_home_work_9.FamilyDao;
import java_core_home_work_9.FamilyService;

public class Program {
    public static void main(String[] args) {

        FamilyDao dao = new CollectionFamilyDao();
        FamilyService service = new FamilyService(dao);
        FamilyController controller = new FamilyController(service);


        long birthMother = LocalDate.of(1985, 3, 10).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long birthFather = LocalDate.of(1980, 1, 5).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

        Woman mother = new Woman("Anna", "Smith", birthMother, 95);
        Man father = new Man("John", "Smith", birthFather, 90);


        Family family = controller.createNewFamily(mother, father);
        System.out.println("Created family:");
        controller.displayAllFamilies();


        Dog dog = new Dog("Rex", 5, 70, new HashSet<>(Arrays.asList("eat", "run")));
        controller.addPet(0, dog);
        System.out.println("\nAfter adding pet:");
        controller.displayAllFamilies();


        Human adopted = new Human("Mike", "Smith", "20/03/2016", 80);
        controller.adoptChild(family, adopted);
        System.out.println("\nAfter adoption:");
        controller.displayAllFamilies();


        controller.bornChild(family, "Tom", "Lisa");
        System.out.println("\nAfter birth:");
        controller.displayAllFamilies();


        System.out.println("\nFamilies bigger than 3:");
        controller.getFamiliesBiggerThan(3);


        controller.deleteAllChildrenOlderThen(5);
        System.out.println("\nAfter deleting children older than 5:");
        controller.displayAllFamilies();


        System.out.println("\nFamily count: " + controller.count());


        System.out.println("\nPets in family 0: " + controller.getPets(0));


        controller.deleteFamilyByIndex(0);
        System.out.println("\nAfter deleting family 0:");
        controller.displayAllFamilies();
    }
}