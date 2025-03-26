import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Roster {
    private final Scanner sc;
    private final HashMap<String,Employee> currentPositions;
    private final ArrayList<Employee> employeesOnClock;
    private final HashMap<Integer,Employee> allEmployees;

    public Roster(Scanner sc) {
        this.sc = sc;
        this.currentPositions = new HashMap<>();
        this.employeesOnClock = new ArrayList<>();
        this.allEmployees = new HashMap<>();
    }

    public void runProgram() {
        System.out.print("What would you like to do?\n1. Add Employee\n2. View All Employees");
        int option = sc.nextInt();

        switch (option) { 
            case 1:
                System.out.print("Enter employee ID: ");
                int id = sc.nextInt();
                allEmployees.put(id,addEmployee(id));
                break;
            case 2:
                listAllEmployees();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
            
    }

    public Employee addEmployee(int id) {
        System.out.print("Enter the employee's name: ");
        String name = sc.nextLine();
        System.out.print("Is the employee a minor? true/false: ");
        boolean minor = sc.nextBoolean();
        System.out.print("Is the employee Male (false) or Female (true): ");
        boolean gender = sc.nextBoolean();

        return new Employee(id,name,gender,minor);
    }

    public void listAllEmployees() {
        
    }

    public void setSchedule() {
        System.out.print("Enter the filename of the CSV: ");
        String filename = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 1) {
                    String name = values[0];

                    
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file " + e.getMessage());
        }
    }

    public int employeesOnClock() {
        return employeesOnClock.size();
    }

}