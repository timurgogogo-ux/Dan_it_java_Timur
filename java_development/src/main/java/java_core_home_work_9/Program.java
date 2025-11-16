package java_core_home_work_9;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.HashSet;

public class Program {
    public static void main(String[] args) {

        CollectionFamilyDao dao = new CollectionFamilyDao();
        FamilyService service = new FamilyService(dao);
        FamilyController controller = new FamilyController(service);

        // create sample parents
        long momBirth = LocalDate.of(1985, 3, 10).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long dadBirth = LocalDate.of(1980, 1, 5).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

        Woman mother = new Woman("Anna", "Smith", momBirth, 95);
        Man father = new Man("John", "Smith", dadBirth, 90);

        // create and save a family
        Family f1 = controller.createNewFamily(mother, father);

        // add pets
        Dog dog = new Dog("Rex", 5, 70, new HashSet<>(Arrays.asList("eat", "run")));
        controller.addPet(0, dog);

        // adopt child
        Human adopted = new Human("Mike", "Smith", "20/03/2016", 80);
        controller.adoptChild(f1, adopted);

        // born child
        Family updated = controller.bornChild(f1, "Alex", "Anna");
        System.out.println("After birth: " + updated);

        // display families
        System.out.println("\nAll families:");
        controller.displayAllFamilies();

        // count families
        System.out.println("\nCount families: " + controller.count());

        // find families bigger than 3
        System.out.println("\nFamilies bigger than 3 members:");
        controller.getFamiliesBiggerThan(3).forEach(System.out::println);

        // delete children older than 5 years
        controller.deleteAllChildrenOlderThen(5);
        System.out.println("\nAfter deleting children older than 5:");
        controller.displayAllFamilies();

        // get pets of family 0
        System.out.println("\nPets in family 0: " + controller.getPets(0));
    }
}
