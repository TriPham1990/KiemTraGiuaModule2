package com.codegym.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameStudent;
    private LocalDate birthdate;

    @ManyToOne
    @JoinColumn(name = "classes_id")
    private Classes classes;

    public Students() {
    }

    public Students(String nameStudent, LocalDate birthdate) {
        this.nameStudent = nameStudent;
        this.birthdate = birthdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
