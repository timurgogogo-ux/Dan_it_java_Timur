package java_core_hw_8;

import java.util.Set;

public class Dog extends Pet implements Foulable {

    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.DOG;
    }

    @Override
    public void respond() {
        System.out.println("Woof! I'm your dog " + nickname + "!");
    }

    @Override
    public void foul() {
        System.out.println("Dog made a mess... sorry!");
    }
}
