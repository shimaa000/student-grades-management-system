package studentgrades.model;

public class Grade {
    private String studentId;
    private String course;
    private double grade;

    public Grade(String studentId, String course, double grade) {
        this.studentId = studentId;
        this.course = course;
        this.grade = grade;
    }

    public String getStudentId() { return studentId; }
    public String getCourse() { return course; }
    public double getGrade() { return grade; }
}
