package java_core_hw_7;

import java.util.Arrays;
import java.util.HashSet;

public class Program {
    public static void main(String[] args) {
        Woman mother = new Woman("Anna", "Smith", 1985, 95, null);
        Man father = new Man("John", "Smith", 1980, 90, null);
        Family family = new Family(mother, father);

        Dog dog = new Dog("Rex", 5, 70, new HashSet<>(Arrays.asList("eat", "run")));
        DomesticCat cat = new DomesticCat("Murka", 3, 60, new HashSet<>(Arrays.asList("sleep")));
        family.setPets(new HashSet<>(Arrays.asList(dog, cat)));

        Human child = new Human("Mike", "Smith", 2010, 80);
        family.addChild(child);

        System.out.println("Family count: " + family.countFamily());
        mother.greetPet();
        dog.foul();
    }
}
