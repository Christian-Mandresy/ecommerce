package com.e.commerce.service;

import com.e.commerce.model.Produit;

import java.util.List;

public interface ProduitService {
    List findall();

    abstract List finByCategorie(int id);

    List findMulti(String nom, String idcategorie, String prix1, String prix2);
}
