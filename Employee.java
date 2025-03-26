import java.util.ArrayList;
import java.util.HashMap;

public class Employee {
    private final String name;
    private final boolean gender; // False = Male, True = Female
    private final HashMap<String,Integer> positions; // create a hashmap for positions
    private final boolean minor; 
    private final int id;

    public Employee(int id, String name, boolean gender, boolean minor) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.minor = minor;
        this.positions = new HashMap<>();
    }

    public void addPosition(String position, int skill) {
        positions.put(position,skill);
    }

    public int getSkillForPosition(String position) {
        return positions.get(position);
    }

    public String[] getBestSkills() {
        ArrayList<String> bestSkills = new ArrayList<>();
        for (String p: positions.keySet()) {
            bestSkills.add(p);
        }
        return bestSkills.toArray(String[]::new);
    }

    public boolean isMinor() {
        return minor;
    }

    public boolean getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

}