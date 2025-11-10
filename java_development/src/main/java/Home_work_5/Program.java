package Home_work_5;

public class Program {
    public static void main(String[] args) {
        String[][] schedule = {
                {DayOfWeek.MONDAY.name(), "Gym"},
                {DayOfWeek.TUESDAY.name(), "Music"}
        };

        Human mother = new Human("Jane", "Karleone", 1979);
        Human father = new Human("Vito", "Karleone", 1977);

        Family family = new Family(mother, father);

        Pet dog = new Pet(Species.DOG, "Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
        family.setPet(dog);

        Human child = new Human("Michael", "Karleone", 2000, 90, schedule, family);
        family.addChild(child);

        child.greetPet();
        child.describePet();

        System.out.println();
        System.out.println(family);
        System.out.println("Number of family members: " + family.countFamily());

        final int CREATED = 100_000; // змінюй при потребі
        for (int i = 0; i < CREATED; i++) {
            new Human("Name" + i, "Surname" + i, 1980 + (i % 40));
            if (i % 10000 == 0) {
                System.gc();
            }
        }

        System.out.println("Created " + CREATED + " temporary Human objects. Called System.gc()");

        System.gc();
    }
}

