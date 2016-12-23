package com.example.ratanakpek.retrofittest;

/**
 * Created by RatanakPek on 11/21/2016.
 */

public class Student {
    private int StudentId;
    private String StudentName;
    private String StudentMarks;

    public Student(int studentId, String studentName, String studentMarks) {
        StudentId = studentId;
        StudentName = studentName;
        StudentMarks = studentMarks;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentMarks() {
        return StudentMarks;
    }

    public void setStudentMarks(String studentMarks) {
        StudentMarks = studentMarks;
    }
}
