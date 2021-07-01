package com.nexo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "merchandise_users_edit")
public class MerchandiseUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty
    @NotNull
    @Column(name = "id_merchandise")
    private int idMerchandise;

    @JsonProperty
    @NotNull
    @Column(name = "id_user_edited")
    private int idUserEdited;

    public void MerchandiseUsers(int id, int idMerchandise, int idUserEdited) {
        this.id = id;
        this.idMerchandise = idMerchandise;
        this.idUserEdited = idUserEdited;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMerchandise() {
        return idMerchandise;
    }

    public void setIdMerchandise(int idMerchandise) {
        this.idMerchandise = idMerchandise;
    }

    public int getIdUserEdited() {
        return idUserEdited;
    }

    public void setIdUserEdited(int idUserEdited) {
        this.idUserEdited = idUserEdited;
    }
}
