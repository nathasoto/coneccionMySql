package com.example.coneccionmysql.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Personnage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is mandatory")
    private String nom;

    @NotBlank(message = "point de vie  is mandatory")
    private int point_de_vie;

    @NotBlank(message = "type is mandatory")
    private String type;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPoint_de_vie() {
        return point_de_vie;
    }

    public void setPoint_de_vie(int point_de_vie) {
        this.point_de_vie = point_de_vie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
