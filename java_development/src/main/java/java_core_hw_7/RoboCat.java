package java_core_hw_7;

public class RoboCat extends Pet implements Foulable {
    public RoboCat(String nickname, int age, int trickLevel, java.util.Set<String> habits) {
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
