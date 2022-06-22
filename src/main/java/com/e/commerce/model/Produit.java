package com.e.commerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Produit {
    private int id;
    private String nom;
    private double prix;
    private String description;
    private com.e.commerce.model.Categorie Categorie;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prix")
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return id == produit.id &&
                Double.compare(produit.prix, prix) == 0 &&
                Objects.equals(nom, produit.nom) &&
                Objects.equals(description, produit.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prix, description);
    }

    @OneToOne
    @JoinColumn(name = "idcategorie", referencedColumnName = "id", nullable = false)
    public com.e.commerce.model.Categorie getCategorie() {
        return Categorie;
    }

    public void setCategorie(com.e.commerce.model.Categorie categorie) {
        Categorie = categorie;
    }
}
