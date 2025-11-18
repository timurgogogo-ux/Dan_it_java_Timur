package java_core_home_work_9;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java_core_home_work_9.Family;
import java_core_home_work_9.Human;
import java_core_home_work_9.Pet;
import java_core_home_work_9.FamilyDao;

public class FamilyService {

    private final FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        List<Family> list = familyDao.getAllFamilies();
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("[%d] %s%n", i, familyToString(list.get(i)));
        }
    }

    public List<Family> getFamiliesBiggerThan(int memberCount) {
        List<Family> res = new ArrayList<>();
        for (Family f : familyDao.getAllFamilies()) {
            if (f.countFamily() > memberCount) res.add(f);
        }
        res.forEach(f -> System.out.println(familyToString(f)));
        return res;
    }

    public List<Family> getFamiliesLessThan(int memberCount) {
        List<Family> res = new ArrayList<>();
        for (Family f : familyDao.getAllFamilies()) {
            if (f.countFamily() < memberCount) res.add(f);
        }
        res.forEach(f -> System.out.println(familyToString(f)));
        return res;
    }

    public long countFamiliesWithMemberNumber(int number) {
        return familyDao.getAllFamilies().stream()
                .filter(f -> f.countFamily() == number)
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

        boolean isMale = ThreadLocalRandom.current().nextBoolean();
        String childName = isMale ? maleName : femaleName;
        String surname = family.getFather() != null ? family.getFather().getSurname() :
                (family.getMother() != null ? family.getMother().getSurname() : "Unknown");

        long birthMillis = Instant.now().toEpochMilli();
        int iq = averageIq(family.getMother(), family.getFather());

        Human child = new Human(childName, surname, birthMillis, iq);
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
        if (age < 0) return;
        long now = System.currentTimeMillis();
        for (Family f : new ArrayList<>(familyDao.getAllFamilies())) {
            List<Human> toRemove = new ArrayList<>();
            for (Human child : f.getChildren()) {
                int childAge = calculateAgeYears(child.getBirthDate(), now);
                if (childAge > age) toRemove.add(child);
            }
            toRemove.forEach(f::deleteChild);
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

    public void addPet(int familyIndex, Pet pet) {
        Family f = familyDao.getFamilyByIndex(familyIndex);
        if (f == null) return;
        Set<Pet> pets = f.getPets();
        if (pets == null) {
            pets = new HashSet<>();
            f.setPets(pets);
        }
        pets.add(pet);
        familyDao.saveFamily(f);
    }


    private int averageIq(Human m, Human f) {
        int miq = (m != null) ? m.getIq() : 0;
        int fiq = (f != null) ? f.getIq() : 0;
        if (miq == 0 && fiq == 0) return 0;
        return (miq + fiq) / ( (miq>0 && fiq>0) ? 2 : 1 );
    }

    private int calculateAgeYears(long birthMillis, long nowMillis) {
        LocalDate birth = Instant.ofEpochMilli(birthMillis).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now = Instant.ofEpochMilli(nowMillis).atZone(ZoneId.systemDefault()).toLocalDate();
        return java.time.Period.between(birth, now).getYears();
    }

    private String familyToString(Family f) {
        StringBuilder sb = new StringBuilder();
        sb.append("Family{mother=").append(f.getMother() != null ? f.getMother().getName()+" "+f.getMother().getSurname() : "null");
        sb.append(", father=").append(f.getFather() != null ? f.getFather().getName()+" "+f.getFather().getSurname() : "null");
        sb.append(", children=").append(f.getChildren());
        sb.append(", pets=").append(f.getPets());
        sb.append("}");
        return sb.toString();
    }
}