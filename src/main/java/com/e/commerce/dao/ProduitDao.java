package com.e.commerce.dao;

import com.e.commerce.model.Produit;

import java.util.List;

public interface ProduitDao {
    List findall();

    List findByCategorie(int idCateg);

    List findMulti(String nom, String idCategorie, String prix1, String prix2);
}
