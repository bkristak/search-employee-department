/*
Task: Searching for Employees by Department
You are tasked with creating a program to manage employee records by department.
>>> Your program should allow users to: A/ Add new employees to departments. B/ Search for employees by department.
>>> Requirements:Implement a Java program that uses nested HashMaps to store employee records by department.
The outer HashMap should map department names (Strings) to inner HashMaps, where each inner
HashMap maps employee names (Strings) to employee IDs (Integers).
>>> Your program should provide the following functionalities:
> Add Employee: Create a method to add new employees to departments.
The method should take the department name, employee name, and employee ID as parameters.
> Search Employees by Department: Create a method to search for employees by department.
The method should take the department name as input and return a list of employee names along with their IDs.
>>> Test your program by adding several employees to different departments and searching for employees by department.
Note: You may use a Map.Entry object as a key to search for employees by department.
Author: Branislav Kristak, Date: 12.4.2024, Repository:
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HashMap<String, HashMap<String, Integer>> dataTable = new HashMap<>();

        HashMap<String, Integer> employeesENG = new HashMap<>();
        dataTable.put("ENG", employeesENG);

        HashMap<String, Integer> employeesQA = new HashMap<>();
        dataTable.put("QA", employeesQA);

        HashMap<String, Integer> employeesSRC = new HashMap<>();
        dataTable.put("SRC", employeesSRC);

        HashMap<String, Integer> employeesHR = new HashMap<>();
        dataTable.put("HR", employeesHR);

        Scanner scanner = new Scanner(System.in);
        String userInput = "";


        System.out.println("Welcome to the program.");
        System.out.println();


        while (!userInput.equalsIgnoreCase("q")) {

            startProgram();

            System.out.print("Please enter user selection = ");
            userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("q")) {
                System.out.println("The program will quit.");

            } else if (userInput.length() != 1) {
                System.out.println("User shall enter only one character number. Size of entered characters does not match program requirement.");

            } else if (!userInput.equals("1") && !userInput.equals("2")) {
                System.out.println("Invalid input. User shall enter only number values = 1 or 2");

            } else if (userInput.equals("1")) {
                addEmployees(scanner, dataTable);

            } else if (userInput.equals("2")) {
                HashMap<String, Integer> employeeSearch = employeeSearchMethod(scanner, dataTable);

                System.out.println("**********************************************");
                System.out.println("List of employees for the selected department:");

                    if (employeeSearch.isEmpty()) {
                        System.out.println("ALERT: The selected department has no employee entry.");
                    } else {
                        for (Map.Entry<String, Integer> entry : employeeSearch.entrySet()) {
                            System.out.println(" > Employee name = " + entry.getKey() + " | > Employee ID = " + entry.getValue());
                    }
                }
                System.out.println("**********************************************");
            }
        }
        System.out.println("Program ends.");
    }

    public static void startProgram() {
        System.out.println("---------------------------------------------------------");
        System.out.println("Select user choice:");
        System.out.println("   > Add new employees to departments. (select key 1)");
        System.out.println("   > Search for employees by department.(select key 2)");
        System.out.println();
        System.out.println("To quit the program you simply press 'q' once new user input is available.");
        System.out.println();
    }

    public static HashMap<String, Integer> employeeSearchMethod(Scanner scanner,
                                                                HashMap<String, HashMap<String, Integer>> dataTable) {
        String departmentInput;
        boolean inputValidation = true;
        HashMap<String, Integer> employeesList = new HashMap<>();

        System.out.println();
        System.out.println("Please enter number associated with the department.");
        System.out.println("Available departments are: 'ENG - engineering', 'QA - quality', 'SRC - sourcing' and 'HR - human resources'.");
        System.out.println("ENG - 1, QA - 2, SRC - 3, HR - 4.");
        System.out.print("User input = ");

        while (inputValidation) {

            departmentInput = scanner.nextLine();

            if (departmentInput.length() != 1) {
                System.out.println("User shall enter only one character. Numbers of entered characters does not match program requirement.");
                break;

            } else if (!departmentInput.equals("1") && !departmentInput.equals("2") && !departmentInput.equals("3") && !departmentInput.equals("4")) {
                System.out.println("User shall enter only number values = ENG - 1, QA - 2, SRC - 3, HR - 4.");
                break;

            } else {
                switch (departmentInput) {
                    case "1":
                        departmentInput = "ENG";
                        System.out.println("Users selects department ID = ENG.");
                        break;
                    case "2":
                        departmentInput = "QA";
                        System.out.println("Users selects department ID = QA.");
                        break;
                    case "3":
                        departmentInput = "SRC";
                        System.out.println("Users selects department ID = SRC.");
                        break;
                    case "4":
                        departmentInput = "HR";
                        System.out.println("Users selects department ID = HR.");
                        break;
                    default:
                        System.out.println("System error. Contact your admin.");
                        inputValidation = false;
                        break;
                }

                for (Map.Entry<String, HashMap<String, Integer>> entry : dataTable.entrySet()) {
                    String department = entry.getKey();
                    HashMap<String, Integer> departmentEmployees = entry.getValue();
                        if (department.equals(departmentInput)) {
                            employeesList.putAll(departmentEmployees);
                            inputValidation = false;
                            break;
                        }
                }
            }
        }
        return employeesList;
    }

    public static void addEmployees(Scanner scanner, HashMap<String, HashMap<String, Integer>> dataTable) {
        String employeeGivenName = "";
        String employeeLastName = "";
        String employeeDepartment = "";
        int employeeID = 0;
        boolean inputValidation = true;

        System.out.print("Enter employee given name: ");
        employeeGivenName = scanner.nextLine();

        System.out.print("Enter employee last name: ");
        employeeLastName = scanner.nextLine();

        while (inputValidation) {
            System.out.print("Enter employee department (ENG - 1, QA - 2, SRC - 3, HR - 4) = ");
            employeeDepartment = scanner.nextLine();

            if (employeeDepartment.length() != 1) {
                System.out.println("User shall enter only one character. Numbers of entered characters does not match program requirement.");
                break;

            } else if (!employeeDepartment.equals("1") && !employeeDepartment.equals("2") && !employeeDepartment.equals("3") && !employeeDepartment.equals("4")) {
                System.out.println("User shall enter only number values = ENG - 1, QA - 2, SRC - 3, HR - 4.");
                break;

            } else {
                switch (employeeDepartment) {
                    case "1":
                        employeeDepartment = "ENG";
                        System.out.println("Users selects department ID = ENG.");
                        System.out.println();
                        break;
                    case "2":
                        employeeDepartment = "QA";
                        System.out.println("Users selects department ID = QA.");
                        System.out.println();
                        break;
                    case "3":
                        employeeDepartment = "SRC";
                        System.out.println("Users selects department ID = SRC.");
                        System.out.println();
                        break;
                    case "4":
                        employeeDepartment = "HR";
                        System.out.println("Users selects department ID = HR.");
                        System.out.println();
                        break;
                    default:
                        System.out.println("System error. Contact your admin.");
                        System.out.println();
                        break;
                }
                inputValidation = false;
            }
        }

        employeeID = countEmployees(dataTable);

        dataTable.get(employeeDepartment).put(employeeGivenName + " " + employeeLastName, employeeID);
        System.out.println("Department " + employeeDepartment + " updated with new employee data. Name: " + employeeGivenName + " " + employeeLastName + ", ID:" + employeeID + ".");
    }

    public static int countEmployees(HashMap<String, HashMap<String, Integer>> dataTable) {
        int employeeMaxID = 0;

        for (HashMap<String, Integer> department : dataTable.values()) {
            if (department != null) {
                for (Integer employeeID : department.values()) {
                    employeeMaxID = Math.max(employeeMaxID, employeeID);
                }
            }
        }
        return employeeMaxID + 1;
    }
}