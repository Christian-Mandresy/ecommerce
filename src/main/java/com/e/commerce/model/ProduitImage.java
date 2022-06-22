package com.e.commerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "produit_image", schema = "ecommerce", catalog = "")
public class ProduitImage {
    private int id;
    private String nomimage;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nomimage")
    public String getNomimage() {
        return nomimage;
    }

    public void setNomimage(String nomimage) {
        this.nomimage = nomimage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProduitImage that = (ProduitImage) o;
        return id == that.id &&
                Objects.equals(nomimage, that.nomimage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomimage);
    }
}
