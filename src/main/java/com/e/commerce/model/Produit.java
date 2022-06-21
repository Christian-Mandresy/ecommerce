package com.e.commerce.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Produit {
    private int id;
    private String nom;
    private double prix;
    private String description;
    private Set<ProduitCategorie> listcategorie;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 60)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prix", nullable = false, precision = 0)
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
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

    @OneToMany
    public Set<ProduitCategorie> getListcategorie() {
        return listcategorie;
    }

    public void setListcategorie(Set<ProduitCategorie> listcategorie) {
        this.listcategorie = listcategorie;
    }
}
