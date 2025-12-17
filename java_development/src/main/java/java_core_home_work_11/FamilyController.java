package java_core_home_work_11;

import java.util.List;

public class FamilyController {
    private final FamilyService service;

    public FamilyController(FamilyService service) {
        this.service = service;
    }

    public void fillTestData() throws FamilyOverflowException {
        long birthMother = java.time.LocalDate.of(1985, 3, 10).atStartOfDay(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli();
        long birthFather = java.time.LocalDate.of(1980, 1, 5).atStartOfDay(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli();

        service.createNewFamily(new Woman("Anna", "Smith", birthMother, 95),
                new Man("John", "Smith", birthFather, 90));
        service.createNewFamily(new Woman("Kate", "Bibo", birthMother, 90),
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
        if (families.isEmpty()) {
            System.out.println("No families found.");
            return;
        }
        for (int i = 0; i < families.size(); i++) {
            System.out.println((i + 1) + ".\n" + families.get(i).prettyFormat());
        }
    }

    public boolean deleteFamilyByIndex(int index) {
        List<Family> families = service.getAllFamilies();
        if (index >= 0 && index < families.size()) {
            service.deleteFamilyByIndex(index);
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
        return service.getAllFamilies().get(index);
    }

    public void bornChild(Family family, String maleName, String femaleName) throws FamilyOverflowException {
        service.bornChild(family, maleName, femaleName);
    }

    public void adoptChild(Family family, Human child) throws FamilyOverflowException {
        service.adoptChild(family, child);
    }

    public void loadData(List<Family> families) {
        service.loadData(families);
    }

    public void saveToFileIfPossible() {
        service.saveToFileIfPossible();
    }

    public void loadFromFileIfPossible() {
        service.loadFromFileIfPossible();
    }
}
