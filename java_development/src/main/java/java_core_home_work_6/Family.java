package java_core_home_work_6;

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
            mother.setFamily(this);
            father.setFamily(this);
        }

        public void addChild(Human child) {
            Human[] newChildren = Arrays.copyOf(children, children.length + 1);
            newChildren[children.length] = child;
            children = newChildren;
            child.setFamily(this);
        }

        public boolean deleteChild(int index) {
            if (index < 0 || index >= children.length) return false;
            Human[] newChildren = new Human[children.length - 1];
            for (int i = 0, j = 0; i < children.length; i++) {
                if (i != index) newChildren[j++] = children[i];
            }
            children = newChildren;
            return true;
        }

        public boolean deleteChild(Human child) {
            if (children.length == 0) return false;
            int indexToRemove = -1;
            for (int i = 0; i < children.length; i++) {
                if (children[i].equals(child)) {
                    indexToRemove = i;
                    break;
                }
            }
            if (indexToRemove == -1) return false;
            return deleteChild(indexToRemove);
        }

        public int countFamily() {
            return 2 + children.length + (pet != null ? 1 : 0);
        }

        public Human getMother() { return mother; }
        public void setMother(Human mother) { this.mother = mother; }

        public Human getFather() { return father; }
        public void setFather(Human father) { this.father = father; }

        public Human[] getChildren() { return children; }
        public void setChildren(Human[] children) { this.children = children; }

        public Pet getPet() { return pet; }
        public void setPet(Pet pet) { this.pet = pet; }

        @Override
        public String toString() {
            return "Family:\n" +
                    "  Mother: " + mother + "\n" +
                    "  Father: " + father + "\n" +
                    "  Children: " + Arrays.toString(children) + "\n" +
                    "  Pet: " + pet;
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
            System.out.println("Family object is being deleted: " + mother.getSurname() + " family");
        }
}
