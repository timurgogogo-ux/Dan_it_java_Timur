package java_core_home_work_6;

public final class Dog extends Pet implements Foulable {

    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.DOG;
    }

    @Override
    public void  respond() {
        System.out.println("Woof! I'm " + nickname + ", your loyal dog!");
    }

    public void foul() {
        System.out.println("Oops... I made a mess on the carpet!");
    }
}