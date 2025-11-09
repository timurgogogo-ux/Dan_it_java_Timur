package java_core_hw_7;

public final class Man extends Human {
    public Man(String name, String surname, int year, int iq, Family family) {
        super(name, surname, year, iq);
        setFamily(family);
    }

    @Override
    public void greetPet() {
        System.out.println("Hey buddy! How's it going?");
    }

    public void repairCar() {
        System.out.println("Man is repairing the car.");
    }
}

