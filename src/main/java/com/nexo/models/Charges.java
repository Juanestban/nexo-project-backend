package com.nexo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "charges")
public class Charges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty
    @NotNull
    private String name;

    public void Charges(int id, String name) {
        this.id = id;
        this.name = name;
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
}
