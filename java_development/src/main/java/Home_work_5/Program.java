package Home_work_5;

public class Program {
    public static void main(String[] args) {

        String[] habits = {"eat", "drink", "sleep"};
        Pet dog = new Pet(Species.DOG, "Rock", 5, 75, habits);


        Human mother = new Human("Jane", "Karleone", 1979);
        Human father = new Human("Vito", "Karleone", 1977);


        Family family = new Family(mother, father);
        family.setPet(dog);


        String[][] schedule = {
                {DayOfWeek.MONDAY.name(), "Gym"},
                {DayOfWeek.TUESDAY.name(), "Music"}
        };
        Human child = new Human("Michael", "Karleone", 2000, 90, schedule, family);
        family.addChild(child);


        child.greetPet();
        child.describePet();

        System.out.println();
        System.out.println(family);
        System.out.println("Number of family members: " + family.countFamily());


        for (int i = 0; i < 100_000; i++) {
            new Human("Temp", "User", 1990 + (i % 30));
        }
        System.gc();
    }
}

