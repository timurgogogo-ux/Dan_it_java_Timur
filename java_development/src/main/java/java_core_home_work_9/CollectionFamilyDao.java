package java_core_home_work_9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java_core_home_work_9.Family;

public class CollectionFamilyDao implements FamilyDao {

    private final List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return Collections.unmodifiableList(families);
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index < 0 || index >= families.size()) return null;
        return families.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index < 0 || index >= families.size()) return false;
        families.remove(index);
        return true;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return families.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        int idx = families.indexOf(family);
        if (idx >= 0) {
            families.set(idx, family);
        } else {
            families.add(family);
        }
    }
}
