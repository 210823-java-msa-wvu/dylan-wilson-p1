package com.dylan.models;

import javax.persistence.*;

@Entity
@Table(name ="\"TRMS\".employees")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer emp_id;

    @Column (name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "title")
    private String title;

    Employee() {};

    public Employee(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public Employee(String username) {
        this.username = username;
    }

    public Employee(Integer emp_id, String username) {
        this.emp_id = emp_id;
        this.username = username;
    }

    public Employee(Integer emp_id, String username, String password) {
        this.emp_id = emp_id;
        this.username = username;
        this.password = password;
    }
    public Employee(Integer emp_id, String first_name, String last_name,  String title) {
        this.emp_id = emp_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.title = title;
    }


    public Employee(Integer emp_id, String first_name, String last_name, String username, String password, String title) {
        this.emp_id = emp_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.title = title;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
