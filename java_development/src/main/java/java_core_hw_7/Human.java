package java_core_hw_7;

import java.util.Map;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Map<String, String> schedule;
    private Family family;

    public Human(String name, String surname, int year, int iq) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
    }

    public void greetPet() {
        if (family != null && family.getPets() != null) {
            family.getPets().forEach(pet ->
                    System.out.println("Hello, " + pet.getNickname() + "!"));
        }
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Family getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getYear() {
        return year;
    }

    public int getIq() {
        return iq;
    }

    public Map<String, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, String> schedule) {
        this.schedule = schedule;
    }
}

