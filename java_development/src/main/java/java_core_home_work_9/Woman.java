package java_core_home_work_9;

public final class Woman extends Human {

    public Woman(String name, String surname, long birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public Woman(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    @Override
    public void greetPet() {
        System.out.println("Hello my dear pet!");
        super.greetPet();
    }

    public void makeup() {
        System.out.println("Woman is doing makeup.");
    }
}
