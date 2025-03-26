package schedule_manager;

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
    private final HashMap<String,Employee> allEmployees;
    private final String allEmployeesFile = "employees.csv";
    private final String onClockEmployeesFile = "employees-on-clock.csv";

    public Roster(Scanner sc) {
        this.sc = sc;
        this.currentPositions = new HashMap<>();
        this.employeesOnClock = new ArrayList<>();
        this.allEmployees = new HashMap<>();
    }

    public void runProgram() {

        loadAllEmployees();

        System.out.print("What would you like to do?\n1. Add Employee\n2. View All Employees");
        int option = sc.nextInt();

        switch (option) { 
            case 1:
                System.out.print("Enter employee name: ");
                String name = sc.nextLine();
                allEmployees.put(name,addEmployee(name));
                break;
            case 2:
                listAllEmployees();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
            
    }

    public Employee addEmployee(String name) {
        System.out.print("Is the employee a minor? true/false: ");
        boolean minor = sc.nextBoolean();
        System.out.print("Is the employee Male (false) or Female (true): ");
        boolean gender = sc.nextBoolean();

        return new Employee(name,gender,minor);
    }

    public void listAllEmployees() {
        
    }

    public Employee getEmployee(String name) {
        return allEmployees.get(name);
    }

    public void setSchedule() {

        try (BufferedReader br = new BufferedReader(new FileReader(onClockEmployeesFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 1) {
                    String name = values[0];   
                    employeesOnClock.add(getEmployee(name));
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file " + e.getMessage());
        }
    }

    public void loadAllEmployees() {

        System.out.println("Loading Employees from " + allEmployeesFile);

        try (BufferedReader br = new BufferedReader(new FileReader(allEmployeesFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    String name = values[0];  
                    boolean gender = Boolean.parseBoolean(values[1]);
                    boolean minor = Boolean.parseBoolean(values[2]);

                    // Create an employee object and add it to all employees
                    allEmployees.put(name,new Employee(name,gender,minor));
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file " + e.getMessage());
        }

        System.out.println("Loading Complete!\n\n");
    }
    public int employeesOnClock() {
        return employeesOnClock.size();
    }

}