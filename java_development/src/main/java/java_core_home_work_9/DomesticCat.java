package java_core_home_work_9;

import java.util.Set;

public class DomesticCat extends Pet implements Foulable {

    public DomesticCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.DOMESTIC_CAT;
    }

    @Override
    public void respond() {
        System.out.println("Meow! I'm your cat " + nickname + "!");
    }

    @Override
    public void foul() {
        System.out.println("Cat scratched the sofa!");
    }
}
