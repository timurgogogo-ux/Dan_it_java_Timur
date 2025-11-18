package java_core_home_work_10;

import java.util.ArrayList;
import java.util.List;

public class FamilyService {
    private FamilyDao dao;

    public FamilyService(FamilyDao dao) {
        this.dao = dao;
    }

    public void createNewFamily(Woman mother, Man father) throws FamilyOverflowException {
        dao.saveFamily(new Family(mother, father));
    }

    public List<Family> getAllFamilies() {
        return dao.getAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int n) {
        List<Family> result = new ArrayList<Family>();
        for (Family f : dao.getAllFamilies()) {
            if (f.countFamily() > n) result.add(f);
        }
        return result;
    }

    public List<Family> getFamiliesLessThan(int n) {
        List<Family> result = new ArrayList<Family>();
        for (Family f : dao.getAllFamilies()) {
            if (f.countFamily() < n) result.add(f);
        }
        return result;
    }

    public int countFamiliesWithMemberNumber(int n) {
        int count = 0;
        for (Family f : dao.getAllFamilies()) {
            if (f.countFamily() == n) count++;
        }
        return count;
    }

    public void deleteAllChildrenOlderThen(int age) {
        for (Family f : dao.getAllFamilies()) {
            f.removeChildrenOlderThan(age);
        }
    }

    public void bornChild(Family family, String maleName, String femaleName) throws FamilyOverflowException {
        family.bornChild(maleName, femaleName);
    }

    public void adoptChild(Family family, Human child) throws FamilyOverflowException {
        family.addChild(child);
    }
}
