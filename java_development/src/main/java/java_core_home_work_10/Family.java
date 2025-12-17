package java_core_home_work_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Family {
    private Woman mother;
    private Man father;
    private List<Human> children;
    private Pet pet;

    public Family(Woman mother, Man father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<Human>();
    }

    public int countFamily() {
        int count = 2; // mother + father
        count += children.size();
        if (pet != null) count++;
        return count;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void bornChild(String maleName, String femaleName) {

        Human child = new Human(maleName, femaleName, System.currentTimeMillis(), 100);
        addChild(child);
    }

    public List<Human> getChildren() {
        return children;
    }

    public void removeChildrenOlderThan(int age) {
        long currentYear = java.time.LocalDate.now().getYear();
        Iterator<Human> iterator = children.iterator();
        while (iterator.hasNext()) {
            Human child = iterator.next();
            int birthYear = java.time.Instant.ofEpochMilli(child.getBirthDate())
                    .atZone(java.time.ZoneId.systemDefault())
                    .toLocalDate().getYear();
            if ((currentYear - birthYear) > age) {
                iterator.remove();
            }
        }
    }

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mother: ").append(mother.getName()).append(" ").append(mother.getSurname()).append("\n");
        sb.append("Father: ").append(father.getName()).append(" ").append(father.getSurname()).append("\n");
        sb.append("Children: ");
        if (children.isEmpty()) sb.append("No children");
        else {
            for (Human c : children) sb.append(c.getName()).append(" ").append(c.getSurname()).append(", ");
        }
        return sb.toString();
    }

    public Woman getMother() { return mother; }
    public Man getFather() { return father; }
    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }
}