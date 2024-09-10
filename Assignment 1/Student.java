// Imports
import java.util.ArrayList;

/*
 * Student.java
 * This class represents a student with a name, student ID, and grades.
 * It has methods to add a grade, get the average grade, and get the student's name and ID.
 */
public class Student {
    // Instance Variables
    private String name;
    private String studentID;
    private ArrayList<Integer> grades;

    // Constructor
    public Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
        this.grades = new ArrayList<Integer>();
    }

    // Add a grade to the student's list of grades
    public void addGrade(int grade) {
        grades.add(grade);
    }

    // Return the average grade of the student
    public double getAverageGrade() {
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
