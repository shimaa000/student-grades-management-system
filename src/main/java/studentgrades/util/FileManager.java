package studentgrades.util;

import studentgrades.model.Grade;
import studentgrades.model.Student;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private static final String DATA_FOLDER = "data";
    private static final String STUDENTS_FILE = DATA_FOLDER + "/students.txt";
    private static final String GRADES_FILE = DATA_FOLDER + "/grades.txt";

    private static void prepareFiles() {
        try {
            File folder = new File(DATA_FOLDER);
            if (!folder.exists()) {
                folder.mkdir();
            }
            new File(STUDENTS_FILE).createNewFile();
            new File(GRADES_FILE).createNewFile();
        } catch (IOException e) {
            System.out.println("Error preparing files.");
        }
    }

    public static ArrayList<Student> readStudents() {
        prepareFiles();
        ArrayList<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(STUDENTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    students.add(new Student(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading students.");
        }
        return students;
    }

    public static ArrayList<Grade> readGrades() {
        prepareFiles();
        ArrayList<Grade> grades = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(GRADES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    grades.add(new Grade(parts[0], parts[1], Double.parseDouble(parts[2])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading grades.");
        }
        return grades;
    }

    public static boolean studentExists(String id) {
        for (Student student : readStudents()) {
            if (student.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static void saveStudent(Student student) {
        prepareFiles();
        try (FileWriter writer = new FileWriter(STUDENTS_FILE, true)) {
            writer.write(student.getId() + "," + student.getName() + "," + student.getMajor() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving student.");
        }
    }

    public static void saveGrade(Grade grade) {
        prepareFiles();
        try (FileWriter writer = new FileWriter(GRADES_FILE, true)) {
            writer.write(grade.getStudentId() + "," + grade.getCourse() + "," + grade.getGrade() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving grade.");
        }
    }
}
