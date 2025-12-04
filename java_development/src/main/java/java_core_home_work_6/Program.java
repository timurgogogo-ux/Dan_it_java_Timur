package java_core_home_work_6;


    public class Program {
        public static void main(String[] args) {

            String[] habits = {"eat", "sleep", "play"};
            Pet dog = new Dog("Rocky", 5, 75, habits);

            Human mother = new Woman("Jane", "Karleone", 1979);
            Human father = new Man("Vito", "Karleone", 1977);

            Family family = new Family(mother, father);
            family.setPet(dog);

            String[][] schedule = {
                    {DayOfWeek.MONDAY.name(), "Gym"},
                    {DayOfWeek.TUESDAY.name(), "Music"}
            };

            Human child = new Man("Michael", "Karleone", 2000, 90, schedule, family);
            family.addChild(child);

            child.greetPet();
            child.describePet();

            System.out.println();
            System.out.println(family);
            System.out.println("Number of family members: " + family.countFamily());
        }
    }

