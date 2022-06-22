package com.e.commerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Categorie {
    private int id;
    private String nom;
    private Integer idParent;
    private Set<Produit> listProduit;

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
    @Column(name = "id_parent")
    public Integer getIdParent() {
        return idParent;
    }

    public void setIdParent(Integer idParent) {
        this.idParent = idParent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return id == categorie.id &&
                Objects.equals(nom, categorie.nom) &&
                Objects.equals(idParent, categorie.idParent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, idParent);
    }

    @ManyToMany(mappedBy = "listCategorie")
    @JsonIgnore
    public Set<Produit> getListProduit() {
        return listProduit;
    }

    public void setListProduit(Set<Produit> listProduit) {
        this.listProduit = listProduit;
    }
}
