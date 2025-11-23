package java_core_home_work_11;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Human implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String name;
    private String surname;
    private long birthDate; // epoch milli
    private int iq;
    private Map<String, String> schedule;

    public Human(String name, String surname, long birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
    }

    public String prettyFormat() {
        return String.format("{name='%s', surname='%s', birthDate='%s', iq=%d, schedule=%s}",
                name, surname, getBirthDateFormatted(), iq, schedule);
    }

    private String getBirthDateFormatted() {
        try {
            return Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate().format(FORMATTER);
        } catch (Exception e) {
            return String.valueOf(birthDate);
        }
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public long getBirthDate() { return birthDate; }
    public int getIq() { return iq; }
}
