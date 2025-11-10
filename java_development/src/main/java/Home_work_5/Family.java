package Home_work_5;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        if (mother != null) mother.setFamily(this);
        if (father != null) father.setFamily(this);
    }

    public void addChild(Human child) {
        if (child == null) return;
        Human[] newChildren = Arrays.copyOf(children, children.length + 1);
        newChildren[children.length] = child;
        children = newChildren;
        child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.length) return false;
        Human[] newChildren = new Human[children.length - 1];
        for (int i = 0, j = 0; i < children.length; i++) {
            if (i != index) {
                newChildren[j++] = children[i];
            }
        }
        children = newChildren;
        return true;
    }

    public boolean deleteChild(Human child) {
        if (child == null) return false;
        for (int i = 0; i < children.length; i++) {
            if (children[i].equals(child)) {
                return deleteChild(i);
            }
        }
        return false;
    }

    public int countFamily() {
        // count only humans: mother + father + children
        return 2 + children.length;
    }

    public Human getMother() { return mother; }
    public void setMother(Human mother) {
        this.mother = mother;
        if (mother != null) mother.setFamily(this);
    }

    public Human getFather() { return father; }
    public void setFather(Human father) {
        this.father = father;
        if (father != null) father.setFamily(this);
    }

    public Human[] getChildren() { return children; }
    public void setChildren(Human[] children) {
        this.children = children == null ? new Human[0] : children;
        for (Human c : this.children) if (c != null) c.setFamily(this);
    }

    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + (mother != null ? mother.getName() + " " + mother.getSurname() : "null") +
                ", father=" + (father != null ? father.getName() + " " + father.getSurname() : "null") +
                ", children=" + Arrays.toString(children) +
                ", pet=" + (pet != null ? pet.toString() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Finalizing Family: " + this);
        } finally {
            super.finalize();
        }
    }
}

