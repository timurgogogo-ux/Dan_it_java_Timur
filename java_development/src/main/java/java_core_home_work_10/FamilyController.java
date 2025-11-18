package java_core_home_work_10;

import java.util.List;

public class FamilyController {
    private FamilyService service;

    public FamilyController(FamilyService service) {
        this.service = service;
    }

    public void fillTestData() throws FamilyOverflowException {
        long birthMother = 631152000000L; // 1985-03-10
        long birthFather = 315532800000L; // 1980-01-05

        createNewFamily(new Woman("Anna", "Smith", birthMother, 95),
                new Man("John", "Smith", birthFather, 90));
        createNewFamily(new Woman("Kate", "Bibo", birthMother, 90),
                new Man("Karl", "Bibo", birthFather, 85));
    }

    public void createNewFamily(Woman mother, Man father) throws FamilyOverflowException {
        service.createNewFamily(mother, father);
    }

    public List<Family> getAllFamilies() {
        return service.getAllFamilies();
    }

    public void displayAllFamilies() {
        List<Family> families = service.getAllFamilies();
        for (int i = 0; i < families.size(); i++) {
            System.out.println((i+1) + ".\n" + families.get(i).prettyFormat());
        }
    }

    public boolean deleteFamilyByIndex(int index) {
        List<Family> families = service.getAllFamilies();
        if (index >= 0 && index < families.size()) {
            families.remove(index);
            return true;
        }
        return false;
    }

    public List<Family> getFamiliesBiggerThan(int n) {
        return service.getFamiliesBiggerThan(n);
    }

    public List<Family> getFamiliesLessThan(int n) {
        return service.getFamiliesLessThan(n);
    }

    public int countFamiliesWithMemberNumber(int n) {
        return service.countFamiliesWithMemberNumber(n);
    }

    public void deleteAllChildrenOlderThen(int age) {
        service.deleteAllChildrenOlderThen(age);
    }

    public Family getFamilyById(int index) {
        List<Family> families = service.getAllFamilies();
        if (index >= 0 && index < families.size()) {
            return families.get(index);
        }
        return null;
    }

    public void bornChild(Family family, String maleName, String femaleName) throws FamilyOverflowException {
        service.bornChild(family, maleName, femaleName);
    }

    public void adoptChild(Family family, Human child) throws FamilyOverflowException {
        service.adoptChild(family, child);
    }
}