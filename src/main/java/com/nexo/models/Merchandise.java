package com.nexo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "merchandise")
public class Merchandise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @JsonProperty
    @NotNull
    @Column(name = "name_product")
    private String nameProduct;

    @JsonProperty
    @NotNull
    private int quantity;

    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull
    @Column(name = "admission_date")
    private String admissionDate;

    @JsonProperty
    @NotNull
    @Column(name = "user_register")
    private int userRegister;

    @JsonProperty
    @NotNull
    @Column(name = "id_control_merchandise")
    private int idControlMerchandise;

    public void Merchandise(int id, String nameProduct, int quantity, String admissionDate, int userRegister, int idControlMerchandise) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.admissionDate = admissionDate;
        this.userRegister = userRegister;
        this.idControlMerchandise = idControlMerchandise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIdControlMerchandise() {
        return idControlMerchandise;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public int getUserRegister() {
        return userRegister;
    }

    public void setUserRegister(int userRegister) {
        this.userRegister = userRegister;
    }

    public void setIdControlMerchandise(int idControlMerchandise) {
        this.idControlMerchandise = idControlMerchandise;
    }
}
