package java_core_hw_8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Human {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String name;
    private String surname;
    private long birthDate; // Unix millis
    private int iq;
    private Map<String, String> schedule;
    private Family family;

    // --- КОНСТРУКТОР ДЛЯ ЗВИЧАЙНИХ ДІТЕЙ/ДОРОСЛИХ ---
    public Human(String name, String surname, long birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
    }

    // --- КОНСТРУКТОР ДЛЯ УСИНОВЛЕНИХ ДІТЕЙ ---
    public Human(String name, String surname, String birthDateString, int iq) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;

        LocalDate date = LocalDate.parse(birthDateString, FORMATTER);
        this.birthDate = date.atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }

    // --- ОПИС ВІКУ ---
    public String describeAge() {
        LocalDate birth = Instant.ofEpochMilli(birthDate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate now = LocalDate.now();

        Period p = Period.between(birth, now);

        return String.format("%d years, %d months, %d days",
                p.getYears(), p.getMonths(), p.getDays());
    }

    // --- ГЕТТЕР ДАТИ ДЛЯ toString() ---
    private String getBirthDateFormatted() {
        return Instant.ofEpochMilli(birthDate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .format(FORMATTER);
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

    public long getBirthDate() {
        return birthDate;
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

    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', birthDate='%s', iq=%d}",
                name, surname, getBirthDateFormatted(), iq);
    }
}
