package com.example.machinetets.models;


import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    long  id;
    @Column(name="student_name",nullable = false)
    String strudentName;
    @Column(name="college_name",nullable = false)
    String collegeName;
    @Column(name="r1marks")
    float round1Marks;
    @Column(name="r2marks")
    float round2Marks;
    @Column(name="r3marks")
    float round3Marks;
    @Column(name="technical_marks")
    float technicalRoundMarks;
    @Column(name="total_marks")
    float totalMarks;
    @Column(name = "result")
    String result;
    @Column(name="student_rank")
    int rank;

    public Student() {}
    public Student(String strudentName, String collegeName, float round1Marks, float round2Marks, float round3Marks) {
        this.strudentName = strudentName;
        this.collegeName = collegeName;
        this.round1Marks = round1Marks;
        this.round2Marks = round2Marks;
        this.round3Marks = round3Marks;
        this.technicalRoundMarks = round3Marks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStrudentName() {
        return strudentName;
    }

    public void setStrudentName(String strudentName) {
        this.strudentName = strudentName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public float getRound1Marks() {
        return round1Marks;
    }

    public void setRound1Marks(float round1Marks) {
        this.round1Marks = round1Marks;
    }

    public float getRound2Marks() {
        return round2Marks;
    }

    public void setRound2Marks(float round2Marks) {
        this.round2Marks = round2Marks;
    }

    public float getRound3Marks() {
        return round3Marks;
    }

    public void setRound3Marks(float round3Marks) {
        this.round3Marks = round3Marks;
    }

    public float getTechnicalRoundMarks() {
        return technicalRoundMarks;
    }

    public void setTechnicalRoundMarks(float technicalRoundMarks) {
        this.technicalRoundMarks = technicalRoundMarks;
    }

    public float getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(float totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
