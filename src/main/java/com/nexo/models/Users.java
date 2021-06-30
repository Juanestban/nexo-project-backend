package com.nexo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty
    @NotNull
    private String name;

    @JsonProperty
    @NotNull
    private int age;

    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull
    private String date_entry_company;

    @JsonProperty
    @NotNull
    private int id_charge;

    public void Users(int id, String name, int age, String date_entry_company, int id_charge) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.date_entry_company = date_entry_company;
        this.id_charge = id_charge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate_entry_company() {
        return date_entry_company;
    }

    public void setDate_entry_company(String date_entry_company) {
        this.date_entry_company = date_entry_company;
    }

    public int getId_charge() {
        return id_charge;
    }

    public void setId_charge(int id_charge) {
        this.id_charge = id_charge;
    }
}
