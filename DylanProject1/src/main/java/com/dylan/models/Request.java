package com.dylan.models;

import javax.persistence.*;

@Entity
@Table(name ="\"TRMS\".requests")
public class Request {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer request_id;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee_id;//should thi be an employee object?????
    // private Integer employee_id;
    @Column
    private String event_date;
    @Column
    private String event_time;
    @Column
    private String event_location;
    @Column
    private String grading_format;
    @Column
    private String event_type;
    @Column
    private String event_description;
    @Column
    private String work_justification;
    @Column
    private Integer event_cost;
    @Column
    private Boolean is_urgent;

    public Request(){}

    public Request(Integer request_id) {
        this.request_id = request_id;
    }

    public Request(Integer request_id, Integer event_cost) {
        this.request_id = request_id;
        this.event_cost = event_cost;
    }

    public Request(Integer request_id, Boolean is_urgent) {
        this.request_id = request_id;
        this.is_urgent = is_urgent;
    }

    public Request(Integer request_id, Employee employee_id, String event_date, String event_time, String event_location, String grading_format, String event_type, String event_description, String work_justification, Integer event_cost, Boolean is_urgent) {
        this.request_id = request_id;
        this.employee_id = employee_id;
        this.event_date = event_date;
        this.event_time = event_time;
        this.event_location = event_location;
        this.grading_format = grading_format;
        this.event_type = event_type;
        this.event_description = event_description;
        this.work_justification = work_justification;
        this.event_cost = event_cost;
        this.is_urgent = is_urgent;
    }

    public Integer getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Integer request_id) {
        this.request_id = request_id;
    }

    public Employee getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Employee employee_id) {
        this.employee_id = employee_id;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public String getEvent_location() {
        return event_location;
    }

    public void setEvent_location(String event_location) {
        this.event_location = event_location;
    }

    public String getGrading_format() {
        return grading_format;
    }

    public void setGrading_format(String grading_format) {
        this.grading_format = grading_format;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public String getWork_justification() {
        return work_justification;
    }

    public void setWork_justification(String work_justification) {
        this.work_justification = work_justification;
    }

    public Integer getEvent_cost() {
        return event_cost;
    }

    public void setEvent_cost(Integer event_cost) {
        this.event_cost = event_cost;
    }

    public Boolean getIs_urgent() {
        return is_urgent;
    }

    public void setIs_urgent(Boolean is_urgent) {
        this.is_urgent = is_urgent;
    }

    @Override
    public String toString() {
        return "Request{" +
                "request_id=" + request_id +
                ", employee_id=" + employee_id +
                ", event_date='" + event_date + '\'' +
                ", event_time='" + event_time + '\'' +
                ", event_location='" + event_location + '\'' +
                ", grading_format='" + grading_format + '\'' +
                ", event_type='" + event_type + '\'' +
                ", event_description='" + event_description + '\'' +
                ", work_justification='" + work_justification + '\'' +
                ", event_cost=" + event_cost +
                ", is_urgent=" + is_urgent +
                '}';
    }
}