package java_core_hw_8;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.HashSet;

public class Program {
    public static void main(String[] args) {

        long birthMother = LocalDate.of(1985, 3, 10)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant().toEpochMilli();

        long birthFather = LocalDate.of(1980, 1, 5)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant().toEpochMilli();

        Woman mother = new Woman("Anna", "Smith", birthMother, 95);
        Man father = new Man("John", "Smith", birthFather, 90);

        Family family = new Family(mother, father);

        Dog dog = new Dog("Rex", 5, 70, new HashSet<>(Arrays.asList("eat", "run")));
        DomesticCat cat = new DomesticCat("Murka", 3, 60, new HashSet<>(Arrays.asList("sleep")));
        family.setPets(new HashSet<>(Arrays.asList(dog, cat)));

        // Усиновлена дитина — дата у форматі dd/MM/yyyy
        Human adopted = new Human("Mike", "Smith", "20/03/2016", 80);
        family.addChild(adopted);

        System.out.println(mother);
        System.out.println("Age of mother: " + mother.describeAge());

        System.out.println("Family count: " + family.countFamily());
        mother.greetPet();
        dog.foul();
    }
}
