package java_core_home_work_11;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao, Serializable {
    private static final long serialVersionUID = 1L;
    private List<Family> families = new ArrayList<>();

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
        if (!families.contains(family)) families.add(family);
    }

    @Override
    public void loadData(List<Family> families) {
        this.families = new ArrayList<>(families == null ? new ArrayList<Family>() : families);
    }
}
