package com.fosuhene.cracks.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private LocalDate dob;
    private LocalDate datejoined;

    @Transient
    private Integer periodWIthUs;

    @Transient
    //transieint means, there is no need to create column for this attributes declared
    //example age is a calulated value once dob is already known.
    private Integer age;
    private String gender;

    //empty constructor
    public Student() {
    }

    //constructor with id;
    public Student(Long id,
                   String fname,
                   String lname,
                   String email,
                   LocalDate dob,
                   LocalDate datejoined,
                   String gender) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.dob = dob;
        this.datejoined = datejoined;
        this.gender = gender;
    }

    //constructor without id
    public Student(String fname,
                   String lname,
                   String email,
                   LocalDate dob,
                   LocalDate datejoined,
                   String gender) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.dob = dob;
        this.datejoined = datejoined;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDatejoined(){ return  datejoined; }
    public void setDatejoined(LocalDate datejoined){ this.datejoined = datejoined; }

    public Integer getAge() {
        //function to calculate age from dob
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPeriodWIthUs(){
        return Period.between(this.datejoined, LocalDate.now()).getYears();
    }

    public void setPeriodWIthUs(Integer periodWIthUs){ this.periodWIthUs = periodWIthUs; }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //toString method

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + datejoined +
                ", dob=" + dob +
                ", age=" + age +
                ", age=" + periodWIthUs +
                ", gender='" + gender + '\'' +
                '}';
    }
}
