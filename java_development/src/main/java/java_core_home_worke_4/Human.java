package java_core_home_worke_4;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    private Family family;

    public Human() {}

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, int iq, String[][] schedule, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
        this.family = family;
    }

    public void greetPet() {
        if (family != null && family.getPet() != null) {
            System.out.println("Hello, " + family.getPet().getNickname());
        } else {
            System.out.println("I don't have a pet.");
        }
    }

    public void describePet() {
        if (family != null && family.getPet() != null) {
            Pet pet = family.getPet();
            String trickDesc = pet.getTrickLevel() > 50 ? "very cunning" : "almost not cunning";
            System.out.printf("I have %s, him %d years, he %s.%n",
                    pet.getSpecies(), pet.getAge(), trickDesc);
        } else {
            System.out.println("No pet.");
        }
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public int getIq() { return iq; }
    public void setIq(int iq) { this.iq = iq; }

    public String[][] getSchedule() { return schedule; }
    public void setSchedule(String[][] schedule) { this.schedule = schedule; }

    public Family getFamily() { return family; }
    public void setFamily(Family family) { this.family = family; }

    @Override
    public String toString() {
        return "Human{name='" + name + "', surname='" + surname +
                "', year=" + year + ", iq=" + iq +
                ", schedule=" + Arrays.deepToString(schedule) + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return year == human.year &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year);
    }
}

