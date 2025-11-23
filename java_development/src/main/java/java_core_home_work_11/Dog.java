package java_core_home_work_11;

import java.util.Set;

public class Dog extends Pet {
    private static final long serialVersionUID = 1L;
    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Woof! I'm " + nickname + "!");
    }
}
