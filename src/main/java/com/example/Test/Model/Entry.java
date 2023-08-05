package com.example.Test.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;


@Entity
//@Table(name="lists")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Adivizi mutleq qeyd etmelisiniz.")
    private String name;
    @NotEmpty(message = "Soyadivizi mutleq qeyd etmelisiniz.")
    private String surname;

    @Min(value = 1)
    private int age;
    @NotEmpty(message = "Isivizi mutleq qeyd etmelisiniz.")
    private String profession;

    public Entry() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }


    public Entry(String name, String surname, int age, String profession) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.profession = profession;
    }
}
