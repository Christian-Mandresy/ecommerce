package com.e.commerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Produit {
    private int id;
    private String nom;
    private double prix;
    private String description;
    private int idcategorie;
    private Categorie categorie;

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

    @Basic
    @Column(name = "idcategorie",insertable = false,updatable = false)
    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return id == produit.id &&
                Double.compare(produit.prix, prix) == 0 &&
                idcategorie == produit.idcategorie &&
                Objects.equals(nom, produit.nom) &&
                Objects.equals(description, produit.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prix, description, idcategorie);
    }

    @OneToOne
    @JoinColumn(name = "idcategorie", referencedColumnName = "id", nullable = false)
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
