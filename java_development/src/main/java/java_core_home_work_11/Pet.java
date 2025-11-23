package java_core_home_work_11;

import java.io.Serializable;
import java.util.Set;

public abstract class Pet implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String nickname;
    protected int age;
    protected int trickLevel;
    protected Set<String> habits;

    public Pet(String nickname, int age, int trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public abstract void respond();

    public String prettyFormat() {
        return String.format("%s{nickname='%s', age=%d, trickLevel=%d, habits=%s}",
                this.getClass().getSimpleName(), nickname, age, trickLevel, habits);
    }

    public String getNickname() { return nickname; }
}
