package com.e.commerce.dao;

import com.e.commerce.model.Produit;

import java.util.List;

public interface ProduitDao {
    List findall();

    List findByCategorie(int idCateg);
}
