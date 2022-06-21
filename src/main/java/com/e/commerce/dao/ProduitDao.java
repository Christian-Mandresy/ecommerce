package com.e.commerce.dao;

import com.e.commerce.model.Produit;
import com.e.commerce.model.ProduitCategorie;

import java.util.List;

public interface ProduitDao {
    List findall();

    void save(Produit prod, ProduitCategorie[] listcat);
}
