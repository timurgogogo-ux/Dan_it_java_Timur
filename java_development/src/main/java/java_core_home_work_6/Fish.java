package java_core_home_work_6;

public final class Fish extends Pet {

    public Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.FISH;
    }

    @Override
    public void respond() {
        System.out.println("Blub blub... I’m " + nickname + ", the fish. I can’t talk!");
    }
}

