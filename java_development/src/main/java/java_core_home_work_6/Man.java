package java_core_home_work_6;

public final class Man extends Human {

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int year, int iq, String[][] schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    @Override
    public void greetPet() {
        if (getFamily() != null && getFamily().getPet() != null) {
            System.out.println("Hey, buddy " + getFamily().getPet().getNickname() + "! Let's go for a walk!");
        } else {
            System.out.println("No pet to greet.");
        }
    }

    public void repairCar() {
        System.out.println("Fixing the car in the garage...");
    }
}
