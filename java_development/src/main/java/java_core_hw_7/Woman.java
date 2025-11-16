package java_core_hw_7;

public final class Woman extends Human {
    public Woman(String name, String surname, int year, int iq, Family family) {
        super(name, surname, year, iq);
        setFamily(family);
    }

    @Override
    public void greetPet() {
        System.out.println("Hello my dear pet!");
    }

    public void makeup() {
        System.out.println("Woman is doing makeup.");
    }
}

