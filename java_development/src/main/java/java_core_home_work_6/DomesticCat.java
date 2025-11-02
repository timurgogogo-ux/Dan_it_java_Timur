package java_core_home_work_6;

public final class DomesticCat extends Pet implements Foulable {

    public void foul DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.DOMESTIC_CAT;
    }

    @Override
    public void  respond() {
        System.out.println("Meow! I'm your cat " + nickname + ". Feed me!");
    }

    public void foul() {
        System.out.println("I knocked over your plant, sorry... maybe.");
    }
}
