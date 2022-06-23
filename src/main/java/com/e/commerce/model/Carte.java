package com.e.commerce.model;

import java.util.Objects;

public class Carte {
    private Produit produit;
    private int quantite;

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        Carte produit = (Carte) o;
        return this.produit.equals(produit.getProduit());
    }
}
