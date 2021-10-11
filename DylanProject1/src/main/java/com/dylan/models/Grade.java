package com.dylan.models;

import javax.persistence.*;

@Entity
@Table(name="grades")
public class Grade {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer grade_id;

    private  char grade;
    private String range;
    private String pass_fail;

    public Grade(){}


    public Grade(Integer grade_id) {
        this.grade_id = grade_id;
    }

    public Grade(Integer grade_id, char grade, String range, String pass_fail) {
        this.grade_id = grade_id;
        this.grade = grade;
        this.range = range;
        this.pass_fail = pass_fail;
    }

    public Integer getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(Integer grade_id) {
        this.grade_id = grade_id;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getPass_fail() {
        return pass_fail;
    }

    public void setPass_fail(String pass_fail) {
        this.pass_fail = pass_fail;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade_id=" + grade_id +
                ", grade=" + grade +
                ", range='" + range + '\'' +
                ", pass_fail='" + pass_fail + '\'' +
                '}';
    }
}
