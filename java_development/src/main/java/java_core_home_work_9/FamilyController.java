package java_core_home_work_9;

import java.util.List;
import java.util.Set;

public class FamilyController {

    private final FamilyService service;

    public FamilyController(FamilyService service) {
        this.service = service;
    }

    public List<Family> getAllFamilies() {
        return service.getAllFamilies();
    }

    public void displayAllFamilies() {
        service.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int memberCount) {
        return service.getFamiliesBiggerThan(memberCount);
    }

    public List<Family> getFamiliesLessThan(int memberCount) {
        return service.getFamiliesLessThan(memberCount);
    }

    public long countFamiliesWithMemberNumber(int memberCount) {
        return service.countFamiliesWithMemberNumber(memberCount);
    }

    public Family createNewFamily(Human mother, Human father) {
        return service.createNewFamily(mother, father);
    }

    public boolean deleteFamilyByIndex(int index) {
        return service.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String maleName, String femaleName) {
        return service.bornChild(family, maleName, femaleName);
    }

    public Family adoptChild(Family family, Human child) {
        return service.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThen(int age) {
        service.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return service.count();
    }

    public Family getFamilyById(int index) {
        return service.getFamilyById(index);
    }

    public Set<Pet> getPets(int familyIndex) {
        return service.getPets(familyIndex);
    }

    public boolean addPet(int familyIndex, Pet pet) {
        return service.addPet(familyIndex, pet);
    }
}

    public int count() {
        return service.count();
    }

    public Family getFamilyById(int index) {
        return service.getFamilyById(index);
    }

    public Set<Pet> getPets(int familyIndex) {
        return service.getPets(familyIndex);
    }

    public boolean addPet(int familyIndex, Pet pet) {
        return service.addPet(familyIndex, pet);
    }
}
