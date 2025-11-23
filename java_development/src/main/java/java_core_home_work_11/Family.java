package java_core_home_work_11;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Family implements Serializable {
    private static final long serialVersionUID = 1L;

    private Woman mother;
    private Man father;
    private List<Human> children;
    private Pet pet;

    public Family(Woman mother, Man father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
    }

    public int countFamily() {
        int count = 2;
        count += children == null ? 0 : children.size();
        if (pet != null) count++;
        return count;
    }

    public void addChild(Human child) {
        if (children == null) children = new ArrayList<>();
        children.add(child);
    }

    public void bornChild(String maleName, String femaleName) {
        boolean isMale = System.currentTimeMillis() % 2 == 0;
        String name = isMale ? maleName : femaleName;
        Human child = new Human(name, father.getSurname(), System.currentTimeMillis(), 100);
        addChild(child);
    }

    public List<Human> getChildren() { return children; }

    public void removeChildrenOlderThan(int age) {
        if (children == null) return;
        int currentYear = java.time.LocalDate.now().getYear();
        Iterator<Human> iterator = children.iterator();
        while (iterator.hasNext()) {
            Human child = iterator.next();
            int birthYear = Instant.ofEpochMilli(child.getBirthDate()).atZone(ZoneId.systemDefault()).toLocalDate().getYear();
            if ((currentYear - birthYear) > age) iterator.remove();
        }
    }

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mother: ").append(mother.getName()).append(" ").append(mother.getSurname()).append("\n");
        sb.append("Father: ").append(father.getName()).append(" ").append(father.getSurname()).append("\n");
        sb.append("Children: ");
        if (children == null || children.isEmpty()) sb.append("No children");
        else {
            for (int i = 0; i < children.size(); i++) {
                Human c = children.get(i);
                sb.append(c.getName()).append(" ").append(c.getSurname());
                if (i < children.size() - 1) sb.append(", ");
            }
        }
        sb.append("\nPet: ").append(pet == null ? "No pet" : pet.prettyFormat());
        return sb.toString();
    }

    public Woman getMother() { return mother; }
    public Man getFather() { return father; }
    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }
}
