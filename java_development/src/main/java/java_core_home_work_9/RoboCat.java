package java_core_home_work_9;

import java.util.Set;

public class RoboCat extends Pet implements Foulable {

    public RoboCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.ROBO_CAT;
    }

    @Override
    public void respond() {
        System.out.println("Beep-boop! I am RoboCat " + nickname + ".");
    }

    @Override
    public void foul() {
        System.out.println("RoboCat spilled oil on the floor!");
    }
}
