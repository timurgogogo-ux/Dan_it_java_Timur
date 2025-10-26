package java_core_home_worke_4;

public class Programs {
    public static void main(String[] args) {

        String[] habits = {"eat", "drink", "sleep"};
        Pet dog = new Pet("dog", "Rock", 5, 75, habits);


        Human mother = new Human("Jane", "Karleone", 1979);
        Human father = new Human("Vito", "Karleone", 1977);


        Family family = new Family(mother, father);
        family.setPet(dog);


        String[][] schedule = {
                {"Monday", "Gym"},
                {"Tuesday", "Music"}
        };
        Human child = new Human("Michael", "Karleone", 2000, 90, schedule, family);
        family.addChild(child);


        child.greetPet();
        child.describePet();

        System.out.println();
        System.out.println(family);
        System.out.println("Number of family members: " + family.countFamily());
    }
}

