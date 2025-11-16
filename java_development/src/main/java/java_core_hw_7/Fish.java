package java_core_hw_7;

public class Fish extends Pet {
    public Fish(String nickname, int age, int trickLevel, java.util.Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.FISH;
    }

    @Override
    public void respond() {
        System.out.println("Blub blub... I'm a fish " + nickname + "!");
    }
}
