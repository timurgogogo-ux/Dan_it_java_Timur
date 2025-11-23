package java_core_home_work_11;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileFamilyDao implements FamilyDao {
    private List<Family> families = new ArrayList<>();
    private final String filePath;

    public FileFamilyDao(String filePath) {
        this.filePath = filePath;
        loadFromFile(); // attempt load at startup
    }

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
        saveToFile();
        return true;
    }

    @Override
    public boolean deleteFamily(Family family) {
        boolean removed = families.remove(family);
        if (removed) saveToFile();
        return removed;
    }

    @Override
    public void saveFamily(Family family) {
        families.add(family);
        saveToFile();
    }

    @Override
    public void loadData(List<Family> families) {
        this.families = new ArrayList<>(families == null ? new ArrayList<Family>() : families);
        saveToFile();
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) return;
        ObjectInputStream in = null;
        try (FileInputStream fis = new FileInputStream(file)) {
            in = new ObjectInputStream(fis);
            Object obj = in.readObject();
            if (obj instanceof List) {
                this.families = (List<Family>) obj;
            }
        } catch (Exception e) {
            System.out.println("Warning: could not load data from file: " + e.getMessage());
            // keep empty list on failure
            this.families = new ArrayList<Family>();
        } finally {
            if (in != null) {
                try { in.close(); } catch (IOException ignored) {}
            }
        }
    }

    public void saveToFile() {
        ObjectOutputStream out = null;
        try {
            File file = new File(filePath);
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) parent.mkdirs();
            out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(families);
        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        } finally {
            if (out != null) {
                try { out.close(); } catch (IOException ignored) {}
            }
        }
    }
}
