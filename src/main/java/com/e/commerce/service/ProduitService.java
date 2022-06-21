package com.e.commerce.service;

import com.e.commerce.model.Produit;
import com.e.commerce.model.ProduitCategorie;

import java.util.List;

public interface ProduitService {
    List findall();

    void save(Produit produit, ProduitCategorie[] produitCategories);
}
