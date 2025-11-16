package java_core_home_work_9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
        // If the same reference exists -> replace; otherwise add to end.
        int idx = families.indexOf(family);
        if (idx >= 0) {
            families.set(idx, family);
            return;
        }

        // Otherwise try to find by mother+father equality (basic logical equality)
        for (int i = 0; i < families.size(); i++) {
            Family f = families.get(i);
            if (f.getMother() != null && f.getFather() != null &&
                    family.getMother() != null && family.getFather() != null) {
                boolean sameParents = Objects.equals(f.getMother().getName(), family.getMother().getName()) &&
                        Objects.equals(f.getMother().getSurname(), family.getMother().getSurname()) &&
                        Objects.equals(f.getFather().getName(), family.getFather().getName()) &&
                        Objects.equals(f.getFather().getSurname(), family.getFather().getSurname());
                if (sameParents) {
                    families.set(i, family);
                    return;
                }
            }
        }

        families.add(family);
    }

    // helper for tests/demo
    public void addInitialFamily(Family family) {
        saveFamily(family);
    }
}
