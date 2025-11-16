package java_core_hw_8;

public final class Man extends Human {

    public Man(String name, String surname, long birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public Man(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    @Override
    public void greetPet() {
        System.out.println("Hey buddy! How's it going?");
        super.greetPet();
    }

    public void repairCar() {
        System.out.println("Man is repairing the car.");
    }
}
