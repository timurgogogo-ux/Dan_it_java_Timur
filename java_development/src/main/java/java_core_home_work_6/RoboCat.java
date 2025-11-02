package java_core_home_work_6;

public final class RoboCat extends Pet implements Foulable {

    public RoboCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.ROBOCAT;
    }

    @Override
    public void respond() {
        System.out.println("Beep-boop! I’m RoboCat " + nickname + ". Ready to serve!");
    }

    public void foul() {
        System.out.println("Battery low... System cleaning activated!");
    }
}
