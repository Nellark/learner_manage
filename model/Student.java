package model;

public class Student
{
    private String studentName;
    private int studentScore;
    private int studentGrade;

    public Student(String sName, int sScore, int sGrade) {
        this.studentName = sName;
        this.studentScore = sScore;
        this.studentGrade = sGrade;
    }

    // Getters and setters
    public String getStudentName() { return studentName; }
    public int getStudentScore() { return studentScore; }
    public int getStudentGrade() { return studentGrade; }

    public void setStudentName(String sName) { this.studentName = sName; }
    public void setStudentScore(int sScore) {
        if (sScore >=0 && sScore <=100){
            this.studentScore = sScore;
        }else{
            throw new IllegalArgumentException("Only between 0 to 100 score allowed.");
        }
    }
    public void setStudentGrade(int sGrade) {
        if (sGrade == 10) {
            this.studentGrade = sGrade;
        } else {
            throw new IllegalArgumentException("Only grade 10 is allowed.");
        }
    }

    @Override
    public String toString() {
        return "Student Name: " + studentName +
                "\nStudent Score: " + studentScore +
                "\nStudent Grade: " + studentGrade;

    }
}
