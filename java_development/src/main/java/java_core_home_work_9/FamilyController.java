package java_core_home_work_9;

import java.util.List;
import java.util.Set;
import java_core_home_work_9.Family;
import java_core_home_work_9.Human;
import java_core_home_work_9.Pet;
import java_core_home_work_9.FamilyService;

public class FamilyController {

    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public List<Family> getAllFamilies() { return familyService.getAllFamilies(); }

    public void displayAllFamilies() { familyService.displayAllFamilies(); }

    public List<Family> getFamiliesBiggerThan(int n) { return familyService.getFamiliesBiggerThan(n); }

    public List<Family> getFamiliesLessThan(int n) { return familyService.getFamiliesLessThan(n); }

    public long countFamiliesWithMemberNumber(int n) { return familyService.countFamiliesWithMemberNumber(n); }

    public Family createNewFamily(Human mother, Human father) { return familyService.createNewFamily(mother, father); }

    public boolean deleteFamilyByIndex(int index) { return familyService.deleteFamilyByIndex(index); }

    public Family bornChild(Family family, String maleName, String femaleName) { return familyService.bornChild(family, maleName, femaleName); }

    public Family adoptChild(Family family, Human child) { return familyService.adoptChild(family, child); }

    public void deleteAllChildrenOlderThen(int age) { familyService.deleteAllChildrenOlderThen(age); }

    public int count() { return familyService.count(); }

    public Family getFamilyById(int index) { return familyService.getFamilyById(index); }

    public Set<Pet> getPets(int familyIndex) { return familyService.getPets(familyIndex); }

    public void addPet(int familyIndex, Pet pet) { familyService.addPet(familyIndex, pet); }
}