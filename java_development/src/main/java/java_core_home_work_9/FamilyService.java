package java_core_home_work_9;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyService {

    private final FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        List<Family> families = getAllFamilies();
        for (int i = 0; i < families.size(); i++) {
            System.out.println(i + ": " + families.get(i));
        }
    }

    public List<Family> getFamiliesBiggerThan(int memberCount) {
        return familyDao.getAllFamilies().stream()
                .filter(f -> f.countFamily() > memberCount)
                .collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int memberCount) {
        return familyDao.getAllFamilies().stream()
                .filter(f -> f.countFamily() < memberCount)
                .collect(Collectors.toList());
    }

    public long countFamiliesWithMemberNumber(int memberCount) {
        return familyDao.getAllFamilies().stream()
                .filter(f -> f.countFamily() == memberCount)
                .count();
    }

    public Family createNewFamily(Human mother, Human father) {
        Family family = new Family(mother, father);
        familyDao.saveFamily(family);
        return family;
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String maleName, String femaleName) {
        if (family == null) return null;

        boolean isMale = Math.random() < 0.5;
        String childName = isMale ? maleName : femaleName;

        // Surname from father if present, otherwise mother
        String surname = family.getFather() != null ? family.getFather().getSurname()
                : (family.getMother() != null ? family.getMother().getSurname() : "Unknown");

        // birthDate = now (start of day)
        long birthMillis = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

        // IQ average of parents (if one missing, use other or default 0)
        int iqFather = family.getFather() != null ? family.getFather().getIq() : 0;
        int iqMother = family.getMother() != null ? family.getMother().getIq() : 0;
        int childIq = (iqFather + iqMother) / ( (family.getFather()!=null && family.getMother()!=null) ? 2 : (family.getFather()!=null || family.getMother()!=null ? 1 : 1));

        Human child = new Human(childName, surname, birthMillis, childIq);
        family.addChild(child);

        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        if (family == null || child == null) return null;
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        LocalDate now = LocalDate.now();
        List<Family> families = familyDao.getAllFamilies();

        for (Family f : families) {
            List<Human> toRemove = new ArrayList<>();
            for (Human c : f.getChildren()) {
                long millis = c.getBirthDate();
                LocalDate birth = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDate();
                int years = Period.between(birth, now).getYears();
                if (years > age) {
                    toRemove.add(c);
                }
            }
            // remove collected
            for (Human r : toRemove) {
                f.deleteChild(r);
            }
            familyDao.saveFamily(f);
        }
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public Set<Pet> getPets(int familyIndex) {
        Family f = familyDao.getFamilyByIndex(familyIndex);
        if (f == null) return Collections.emptySet();
        return f.getPets();
    }

    public boolean addPet(int familyIndex, Pet pet) {
        Family f = familyDao.getFamilyByIndex(familyIndex);
        if (f == null) return false;
        Set<Pet> pets = f.getPets();
        pets.add(pet);
        f.setPets(pets);
        familyDao.saveFamily(f);
        return true;
    }
}
