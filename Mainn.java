import java.io.*;
import java.util.*;

class Main1 {
    private String name;
    private int rollNumber;
    private String grade;

    public Main1(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nRoll Number: " + rollNumber + "\nGrade: " + grade + "\n";
    }
}

class StudentManagementSystem {
    private List<Main1> students;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter roll number: ");
        int rollNumber = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        Main1 student = new Main1(name, rollNumber, grade);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void displayAllStudents() {
        for (Main1 student : students) {
            System.out.println(student);
        }
    }

    // Implement other methods for removing, searching, and editing students

    public void saveDataToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Main1 student : students) {
                writer.println(student.getName() + "," + student.getRollNumber() + "," + student.getGrade());
            }
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }
    }
}

public class Mainn {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Save Data to File");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    system.addStudent();
                    break;
                case 2:
                    system.displayAllStudents();
                    break;
                case 3:
                    System.out.print("Enter file name: ");
                    String fileName = scanner.nextLine();
                    system.saveDataToFile(fileName);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
