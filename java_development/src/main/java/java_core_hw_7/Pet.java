package java_core_hw_7;

import java.util.Set;

public abstract class Pet {
    protected Species species;
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

    public void eat() {
        System.out.println("I am eating!");
    }

    public abstract void respond();

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return String.format("%s{nickname='%s', age=%d, trickLevel=%d, habits=%s}",
                species, nickname, age, trickLevel, habits);
    }
}

