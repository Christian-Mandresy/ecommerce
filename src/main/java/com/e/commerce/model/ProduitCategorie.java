package com.e.commerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "produit_categorie", schema = "ecommerce", catalog = "")
public class ProduitCategorie {
    private int id;
    private int idproduit;
    private int idcategorie;

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
    @Column(name = "idproduit", nullable = false)
    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    @Basic
    @Column(name = "idcategorie", nullable = false)
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
        ProduitCategorie that = (ProduitCategorie) o;
        return id == that.id &&
                idproduit == that.idproduit &&
                idcategorie == that.idcategorie;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idproduit, idcategorie);
    }
}
