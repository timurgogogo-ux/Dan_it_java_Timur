package java_core_home_work_11;

import java.util.ArrayList;
import java.util.List;

public class FamilyService {
    private final FamilyDao dao;

    public FamilyService(FamilyDao dao) {
        this.dao = dao;
    }

    public void createNewFamily(Woman mother, Man father) throws FamilyOverflowException {
        if (mother == null || father == null) throw new IllegalArgumentException("Mother and father must not be null");
        dao.saveFamily(new Family(mother, father));
    }

    public List<Family> getAllFamilies() {
        return dao.getAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int n) {
        List<Family> result = new ArrayList<>();
        for (Family f : dao.getAllFamilies()) {
            if (f.countFamily() > n) result.add(f);
        }
        return result;
    }

    public List<Family> getFamiliesLessThan(int n) {
        List<Family> result = new ArrayList<>();
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
        // if underlying DAO persists automatically, it should be saved by DAO methods when changed
        if (dao instanceof FileFamilyDao) ((FileFamilyDao) dao).saveToFile();
    }

    public void bornChild(Family family, String maleName, String femaleName) throws FamilyOverflowException {
        if (family == null) throw new IllegalArgumentException("Family is null");
        family.bornChild(maleName, femaleName);
        if (dao instanceof FileFamilyDao) ((FileFamilyDao) dao).saveToFile();
    }

    public void adoptChild(Family family, Human child) throws FamilyOverflowException {
        if (family == null || child == null) throw new IllegalArgumentException("Family or child is null");
        family.addChild(child);
        if (dao instanceof FileFamilyDao) ((FileFamilyDao) dao).saveToFile();
    }

    public void deleteFamilyByIndex(int index) {
        dao.deleteFamily(index);
    }

    public void deleteFamily(Family family) {
        dao.deleteFamily(family);
    }

    public void loadData(List<Family> families) {
        dao.loadData(families);
    }

    public void saveToFileIfPossible() {
        if (dao instanceof FileFamilyDao) ((FileFamilyDao) dao).saveToFile();
    }

    public void loadFromFileIfPossible() {
        if (dao instanceof FileFamilyDao) ((FileFamilyDao) dao).loadFromFile();
    }
}
